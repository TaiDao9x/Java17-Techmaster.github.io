package com.example.hk_01_drivermanagement_security.security;

import com.example.hk_01_drivermanagement_security.entity.Driver;
import com.example.hk_01_drivermanagement_security.repository.DriverRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomUserDetailsService implements UserDetailsService {

    DriverRepository driverRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Driver driver = driverRepository.findByUsername(username);
        if (driver == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(driver);
    }
}
