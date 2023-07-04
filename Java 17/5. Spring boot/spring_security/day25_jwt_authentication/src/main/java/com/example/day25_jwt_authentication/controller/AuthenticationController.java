package com.example.day25_jwt_authentication.controller;

import com.example.day25_jwt_authentication.model.request.LoginRequest;
import com.example.day25_jwt_authentication.model.request.RegistrationRequest;
import com.example.day25_jwt_authentication.model.response.JwtResponse;
import com.example.day25_jwt_authentication.repository.UserRepository;
import com.example.day25_jwt_authentication.security.CustomUserDetails;
import com.example.day25_jwt_authentication.security.JwtUtils;
import com.example.day25_jwt_authentication.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/authentication")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    JwtUtils jwtUtils;
    UserService userService;
    UserRepository userRepository;
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Set<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());

        JwtResponse jwtResponse = JwtResponse.builder()
                .jwt(jwt)
                .id(userDetails.getId())
                .username(userDetails.getUsername())
                .roles(roles)
                .build();
        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationRequest request) {
        return userRepository.findByUsername(request.getUsername()).map(user -> new ResponseEntity<>("Username is existed", HttpStatus.BAD_REQUEST))
                .orElseGet(() -> {
                    userService.registerUser(request);
                    return new ResponseEntity<>(null, HttpStatus.CREATED);
                });
    }
}
