package com.example.day01.security;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class SecurityUltils {
    public static Optional<Long> getCurrentUserLoginId() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication()).map(authentication -> {
            if (authentication.getPrincipal() instanceof UserDetails) {
                CustomUserDetails springSecurityUser = (CustomUserDetails) authentication.getPrincipal();
                return springSecurityUser.getId();
            }
            return null;
        });
    }
}
