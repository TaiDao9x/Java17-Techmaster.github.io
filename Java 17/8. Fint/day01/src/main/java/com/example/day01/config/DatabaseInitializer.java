package com.example.day01.config;

import com.example.day01.entity.Role;
import com.example.day01.entity.User;
import com.example.day01.repository.RoleRepository;
import com.example.day01.repository.UserRepository;
import com.example.day01.statics.Roles;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DatabaseInitializer implements CommandLineRunner {

    UserRepository userRepository;

    RoleRepository roleRepository;

    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Optional<Role> roleUserOptional = roleRepository.findByName(Roles.USER);
        if (roleUserOptional.isEmpty()) {
            Role userRole = Role.builder().name(Roles.USER).build();
            roleRepository.save(userRole);
        }

        Optional<Role> roleAdminOptional = roleRepository.findByName(Roles.ADMIN);
        if (roleAdminOptional.isEmpty()) {
            Role adminRole = Role.builder().name(Roles.ADMIN).build();
            roleRepository.save(adminRole);

            Optional<User> admin = userRepository.findByEmail("admin@gmail.com");
            if (admin.isEmpty()) {
                User user = new User();
                user.setEmail("admin@gmail.com");
                user.setPhone("");
                user.setFullName("admin");
                user.setPassword(passwordEncoder.encode("admin123"));
                Set<Role> roles = new HashSet<>();
                roles.add(adminRole);
                user.setRoles(roles);
                userRepository.save(user);
            }
        }
    }

}
