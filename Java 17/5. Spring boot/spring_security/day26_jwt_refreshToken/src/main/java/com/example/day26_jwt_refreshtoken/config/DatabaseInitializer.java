package com.example.day26_jwt_refreshtoken.config;

import com.example.day26_jwt_refreshtoken.entity.Role;
import com.example.day26_jwt_refreshtoken.entity.User;
import com.example.day26_jwt_refreshtoken.repository.RoleRepository;
import com.example.day26_jwt_refreshtoken.repository.UserRepository;
import com.example.day26_jwt_refreshtoken.statics.Roles;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
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
        Role userRole = Role.builder().name(Roles.USER).build();
        Role adminRole = Role.builder().name(Roles.ADMIN).build();
        roleRepository.save(userRole);
        roleRepository.save(adminRole);

        User user = new User();
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin123"));
        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        user.setRoles(roles);
        userRepository.save(user);
    }
}
