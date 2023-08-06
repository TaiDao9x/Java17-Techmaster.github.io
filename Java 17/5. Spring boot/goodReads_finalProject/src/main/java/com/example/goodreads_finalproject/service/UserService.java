package com.example.goodreads_finalproject.service;

import com.example.goodreads_finalproject.entity.Otp;
import com.example.goodreads_finalproject.entity.Role;
import com.example.goodreads_finalproject.entity.User;
import com.example.goodreads_finalproject.exception.*;
import com.example.goodreads_finalproject.model.request.*;
import com.example.goodreads_finalproject.model.response.CommonResponse;
import com.example.goodreads_finalproject.model.response.JwtResponse;
import com.example.goodreads_finalproject.model.response.UserResponse;
import com.example.goodreads_finalproject.repository.OtpRepository;
import com.example.goodreads_finalproject.repository.RefreshTokenRepository;
import com.example.goodreads_finalproject.repository.RoleRepository;
import com.example.goodreads_finalproject.repository.UserRepository;
import com.example.goodreads_finalproject.repository.custom.UserCustomRepository;
import com.example.goodreads_finalproject.security.CustomUserDetails;
import com.example.goodreads_finalproject.security.JwtUtils;
import com.example.goodreads_finalproject.security.SecurityUtils;
import com.example.goodreads_finalproject.statics.Roles;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService {
    @Autowired
    final PasswordEncoder passwordEncoder;
    @Autowired
    final UserRepository userRepository;
    @Autowired
    final RoleRepository roleRepository;
    @Autowired
    final ObjectMapper objectMapper;
    @Autowired
    final RefreshTokenRepository refreshTokenRepository;
    @Autowired
    final JwtUtils jwtUtils;
    @Autowired
    EmailService emailService;
    @Autowired
    OtpRepository otpRepository;
    @Autowired
    UserCustomRepository userCustomRepository;

    @Value("${application.security.refreshToken.tokenValidityMilliseconds}")
    long refreshTokenValidityMilliseconds;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository,
                       RoleRepository roleRepository, ObjectMapper objectMapper,
                       RefreshTokenRepository refreshTokenRepository, JwtUtils jwtUtils) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.objectMapper = objectMapper;
        this.refreshTokenRepository = refreshTokenRepository;
        this.jwtUtils = jwtUtils;
    }

    public void registerUser(RegistrationRequest registrationRequest) {
        Optional<Role> optionalRole = roleRepository.findByName(Roles.USER);
        Set<Role> roles = new HashSet<>();
        roles.add(optionalRole.get());
        User user = User.builder()
                .fullName(registrationRequest.getFullName().equals("") ? registrationRequest.getEmail() : registrationRequest.getFullName())
                .email(registrationRequest.getEmail())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .roles(roles)
                .build();
        userRepository.save(user);
        emailService.sendOtpActivedAccount(user.getEmail());
    }

//    public List<UserResponse> getAll() {
//        List<User> users = userRepository.findAll();
//        if (!CollectionUtils.isEmpty(users)) {
//            return users.stream().map(u -> objectMapper.convertValue(u, UserResponse.class)).collect(Collectors.toList());
//        }
//        return Collections.emptyList();
//    }

//    public UserResponse getDetail(Long id) throws ClassNotFoundException {
//        return userRepository.findById(id).map(u -> objectMapper.convertValue(u, UserResponse.class)).orElseThrow(ClassNotFoundException::new);
//    }

    public JwtResponse refreshToken(RefreshTokenRequest request, HttpServletResponse response) throws RefreshTokenNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String newToken = userRepository.findById(userDetails.getId())
                .flatMap(user -> refreshTokenRepository.findByUserAndRefreshTokenAndInvalidated(user, request.getRefreshToken(), false)
                        .map(refreshToken -> {
                            LocalDateTime createdDateTime = refreshToken.getCreatedDateTime();
                            LocalDateTime expiryTime = createdDateTime.plusSeconds(refreshTokenValidityMilliseconds / 1000);
                            if (expiryTime.isBefore(LocalDateTime.now())) {
                                refreshToken.setInvalidated(true);
                                refreshTokenRepository.save(refreshToken);
                                return null;
                            }
                            return jwtUtils.generateJwtToken(authentication);
                        }))
                .orElseThrow(() -> new UsernameNotFoundException("Tài khoản không tồn tại"));

        if (newToken == null) {
            throw new RefreshTokenNotFoundException();
        }
        JwtResponse jwtResponse = JwtResponse.builder()
                .jwt(newToken)
                .build();

        Cookie jwtCookie = new Cookie("jwtToken", jwtResponse.getJwt());
        jwtCookie.setPath("/");
        response.addCookie(jwtCookie);
        return JwtResponse.builder()
                .jwt(newToken)
                .build();
    }

    @Transactional
    public void logout() {
        Optional<Long> userIdOptional = SecurityUtils.getCurrentUserLoginId();
        if (userIdOptional.isEmpty()) {
            throw new UsernameNotFoundException("Tài khoản không tồn tại");
        }
        refreshTokenRepository.logOut(userIdOptional.get());
        SecurityContextHolder.clearContext();
    }

    public void createUser(CreateUserRequest request) throws ExistedUserException {
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());
        if (userOptional.isPresent()) {
            throw new ExistedUserException();
        }

        Set<Role> roles = roleRepository.findByName(Roles.USER).stream().collect(Collectors.toSet());

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .build();
        userRepository.save(user);
    }

    public void activeAccount(String otpCode) {
        Otp otp = otpRepository.findByOtpCode(otpCode).get();
        User user = otp.getUser();
        user.setActivated(true);
        userRepository.save(user);
    }

    public void sendOtp(String email) {
        emailService.sendOtp(email);
    }


    public Optional<User> findByEmailAndActivated(String email) {
        return userRepository.findByEmailAndActivated(email, true);
    }

    public void checkOtp(String otpCode) throws OtpExpiredException {
        Otp otp = otpRepository.findByOtpCode(otpCode).get();
        if (LocalDateTime.now().isAfter(otp.getExpiredAt())) {
            throw new OtpExpiredException();
        }
    }

    public void resetPassword(ResetPasswordRequest resetPasswordRequest) throws OtpExpiredException {
        Otp otp = otpRepository.findByOtpCode(resetPasswordRequest.getOtpCode()).get();
        if (LocalDateTime.now().isAfter(otp.getExpiredAt())) {
            throw new OtpExpiredException();
        }
        User user = otp.getUser();
        user.setPassword(passwordEncoder.encode(resetPasswordRequest.getNewPassword()));
        userRepository.save(user);
    }

    public CommonResponse<?> searchUser(UserSearchRequest request) {
        try {
            List<UserResponse> users = userCustomRepository.searchUser(request);
            Integer pageIndex = request.getPageIndex();
            Integer pageSize = request.getPageSize();

            PaginationUtils<UserResponse> paginationUtils = new PaginationUtils<>();
            int pageNumber = paginationUtils.getPageNumber(users, pageSize);
            users = paginationUtils.searchData(users, pageIndex, pageSize);
            return CommonResponse.builder()
                    .pageNumber(pageNumber)
                    .data(users)
                    .build();
        } catch (Exception e) {
            throw new NotFoundException("Page index out of bound!");
        }
    }
}
