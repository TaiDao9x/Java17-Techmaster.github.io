package com.example.day26_jwt_refreshtoken.controller;

import com.example.day26_jwt_refreshtoken.entity.RefreshToken;
import com.example.day26_jwt_refreshtoken.exception.RefreshTokenNotFoundException;
import com.example.day26_jwt_refreshtoken.model.request.LoginRequest;
import com.example.day26_jwt_refreshtoken.model.request.RefreshTokenRequest;
import com.example.day26_jwt_refreshtoken.model.request.RegistrationRequest;
import com.example.day26_jwt_refreshtoken.model.response.JwtResponse;
import com.example.day26_jwt_refreshtoken.repository.RefreshTokenRepository;
import com.example.day26_jwt_refreshtoken.repository.UserRepository;
import com.example.day26_jwt_refreshtoken.security.CustomUserDetails;
import com.example.day26_jwt_refreshtoken.security.JwtUtils;
import com.example.day26_jwt_refreshtoken.service.UserService;
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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.UUID;
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
    RefreshTokenRepository refreshTokenRepository;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Set<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());

        String refreshToken = UUID.randomUUID().toString();
        RefreshToken refreshTokenEntity = RefreshToken.builder()
                .refreshToken(refreshToken)
                .user(userRepository.findById(userDetails.getId()).get())
                .build();
        refreshTokenRepository.save(refreshTokenEntity);

        JwtResponse jwtResponse = JwtResponse.builder()
                .jwt(jwt)
                .refreshToken(refreshToken)
                .id(userDetails.getId())
                .username(userDetails.getUsername())
                .roles(roles)
                .build();
        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationRequest request) {
        return userRepository.findByUsername(request.getUsername()).map(user -> new ResponseEntity<>("Username is existed", HttpStatus.BAD_REQUEST))
                .orElseGet(() -> {
                    userService.registerUser(request);
                    return new ResponseEntity<>(null, HttpStatus.CREATED);
                });
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestBody @Valid RefreshTokenRequest request) throws RefreshTokenNotFoundException {
        try {
            return ResponseEntity.ok(userService.refreshToken(request));
        } catch (RefreshTokenNotFoundException | UsernameNotFoundException ex) {
            return new ResponseEntity<>("Thông tin refreshToken không chính xác", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/logout")
    public void logout() {
        userService.logout();
    }
}
