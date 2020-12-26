package com.example.car_service.config;

import com.example.car_service.services.UserService;
import com.example.car_service.services.interfaces.UserServiceInterface;
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
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class  SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserServiceInterface userService;

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

            .authorizeRequests()
            .antMatchers("/secured").hasAnyAuthority("ADMIN", "TEACHER")

            .and()

            .formLogin()
            .loginPage("/login")
            .permitAll()

            .and()

            .exceptionHandling().accessDeniedPage("/unauthorized")

            .and()

            .logout()
            .permitAll()
            .logoutSuccessUrl("/login")
            .permitAll();
    }
}
