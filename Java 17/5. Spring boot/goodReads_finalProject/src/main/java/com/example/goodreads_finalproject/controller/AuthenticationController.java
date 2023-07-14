package com.example.goodreads_finalproject.controller;

import com.example.goodreads_finalproject.entity.RefreshToken;
import com.example.goodreads_finalproject.entity.User;
import com.example.goodreads_finalproject.exception.BadRequestException;
import com.example.goodreads_finalproject.exception.OtpExpiredException;
import com.example.goodreads_finalproject.exception.RefreshTokenNotFoundException;
import com.example.goodreads_finalproject.model.request.ChangePasswordRequest;
import com.example.goodreads_finalproject.model.request.LoginRequest;
import com.example.goodreads_finalproject.model.request.RefreshTokenRequest;
import com.example.goodreads_finalproject.model.request.RegistrationRequest;
import com.example.goodreads_finalproject.model.response.JwtResponse;
import com.example.goodreads_finalproject.repository.OtpRepository;
import com.example.goodreads_finalproject.repository.RefreshTokenRepository;
import com.example.goodreads_finalproject.repository.UserRepository;
import com.example.goodreads_finalproject.security.CustomUserDetails;
import com.example.goodreads_finalproject.security.JwtUtils;
import com.example.goodreads_finalproject.service.UserService;
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
import java.util.Optional;
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

    RefreshTokenRepository refreshTokenRepository;

    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public JwtResponse authenticateUser(@Valid @RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

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

        return JwtResponse.builder()
                .jwt(jwt)
                .refreshToken(refreshToken)
                .id(userDetails.getId())
                .email(userDetails.getUsername())
                .roles(roles)
                .build();
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationRequest request) {
        return userRepository.findByEmail(request.getEmail())
                .map(user -> new ResponseEntity<>("Username is existed", HttpStatus.BAD_REQUEST))
                .orElseGet(() -> {
                    userService.registerUser(request);
                    return new ResponseEntity<>(null, HttpStatus.CREATED);
                });
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        userService.logout();
        return ResponseEntity.ok(null);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestBody @Valid RefreshTokenRequest request) {
        try {
            return ResponseEntity.ok(userService.refreshToken(request));
        } catch (RefreshTokenNotFoundException | UsernameNotFoundException ex) {
            return new ResponseEntity<>("Thông tin refreshToken không chính xác", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/otp-sending/{email}")
    public ResponseEntity<?> sendOtp(@PathVariable String email) {
        return userRepository.findByEmail(email)
                .map(user -> {
                    userService.sendOtp(email);
                    return new ResponseEntity<>(null, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>("Email not exist", HttpStatus.NOT_FOUND));
    }

    @PutMapping("/password-reset/{email}")
    public ResponseEntity<?> resetPassword(@PathVariable String email, @RequestBody ChangePasswordRequest changePasswordRequest) {
        return userRepository.findByEmail(email)
                .map(user -> {
                    try {
                        userService.resetPassword(email, changePasswordRequest);
                        return new ResponseEntity<>("Success", HttpStatus.OK);
                    } catch (OtpExpiredException e) {
                        return new ResponseEntity<>("Otp đã hết hạn", HttpStatus.BAD_REQUEST);
                    }
                })
                .orElseGet(() -> new ResponseEntity<>("Email not exist", HttpStatus.NOT_FOUND));
    }

    @PutMapping("/password-change/{email}")
    public ResponseEntity<?> changePassword(@PathVariable String email, @RequestBody ChangePasswordRequest changePasswordRequest) {
        return userRepository.findByEmail(email)
                .map(user -> {
                    try {
                        userService.changePassword(email, changePasswordRequest);
                        return new ResponseEntity<>("Change password success", HttpStatus.OK);
                    } catch (BadRequestException e) {
                        return new ResponseEntity<>("Wrong old password", HttpStatus.OK);
                    }

                })
                .orElseGet(() -> new ResponseEntity<>("Email not exist", HttpStatus.NOT_FOUND));
    }
}
