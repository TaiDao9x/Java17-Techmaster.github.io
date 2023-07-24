package com.example.goodreads_finalproject.controller.user;

import com.example.goodreads_finalproject.exception.ExistedUserException;
import com.example.goodreads_finalproject.exception.OtpExpiredException;
import com.example.goodreads_finalproject.model.request.ResetPasswordRequest;
import com.example.goodreads_finalproject.model.request.CreateUserRequest;
import com.example.goodreads_finalproject.model.request.EmailRequest;
import com.example.goodreads_finalproject.model.response.UserResponse;
import com.example.goodreads_finalproject.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserResponse getDetail(@PathVariable Long id) throws ClassNotFoundException {
        return userService.getDetail(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateUserRequest request) {
        try {
            userService.createUser(request);
            return ResponseEntity.ok(null);
        } catch (ExistedUserException ex) {
            return new ResponseEntity<>("Email existed", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/otp-sending")
    public ResponseEntity<?> sendOtp(@RequestBody @Valid EmailRequest emailRequest) {
        return userService.findByEmailAndActivated(emailRequest.getEmail())
                .map(user -> {
                    userService.sendOtp(emailRequest.getEmail());
                    return new ResponseEntity<>(null, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>("Email not exist or not activated", HttpStatus.NOT_FOUND));
    }


    @PutMapping("/password-reset")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) throws OtpExpiredException {
        userService.resetPassword(resetPasswordRequest);
        return new ResponseEntity<>("Change password successful", HttpStatus.OK);
    }

}
