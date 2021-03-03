package com.example.car_service.config;

import com.example.car_service.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class  SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userService)
            .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()

                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()

                .and()

                .authorizeRequests()

                /**
                 * Client Requests
                 */
                .antMatchers("/my-cars").hasAuthority("CLIENT")

                /**
                 * Service Employee Requests
                 */
                .antMatchers("/pending-appointments").hasAuthority("CAR_SHOP_EMPLOYEE")

                .and()

                .exceptionHandling().accessDeniedPage("/unauthorized")

                .and()

                .logout()
                .permitAll()
                .logoutSuccessUrl("/login")
                .permitAll();
    }
}
