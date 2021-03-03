package com.example.car_service.data.seed;

import com.example.car_service.data.entity.User;
import com.example.car_service.utils.CsvReader;
import com.example.car_service.data.entity.Role;
import com.example.car_service.data.repository.RoleRepository;
import com.example.car_service.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class UserDataSeeder implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private CsvReader csvReader;

    @Override
    public void run(String... args) throws Exception {
        seedRoles();
        seedUsers();
    }

    private void seedRoles() throws Exception {
        if (roleRepository.count() > 0) {
            return;
        }

        csvReader.readFile("data_seeds/roles.csv").forEach((row) -> {
            Role role = new Role();
            role.setAuthority(row.get(0));
            roleRepository.save(role);
        });
    }

    private void seedUsers() throws Exception {
        if (userRepository.count() > 0) {
            return;
        }

        csvReader.readFile("data_seeds/users.csv").forEach((row) -> {
            Role role = roleRepository.findByAuthority(row.get(2));

            User user = new User();
            user.setUsername(row.get(0));
            user.setPassword(encoder.encode(row.get(1)));
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setEnabled(true);
            user.setCredentialsNonExpired(true);
            user.setAuthorities(new HashSet<Role>(Arrays.asList(role)));

            userRepository.save(user);
        });
    }
}
