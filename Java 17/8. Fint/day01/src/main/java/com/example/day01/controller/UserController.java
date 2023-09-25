package com.example.day01.controller;

import com.example.day01.model.request.UpdateUserRequest;
import com.example.day01.model.request.UserSearchRequest;
import com.example.day01.model.response.CommonResponse;
import com.example.day01.model.response.UserResponse;
import com.example.day01.security.SecurityUltils;
import com.example.day01.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/v1/users")
public class UserController {

    UserService userService;

    @GetMapping()
    public ResponseEntity<?> getAllUsers(UserSearchRequest request) {
        CommonResponse<?> userResponseList = userService.searchUsers(request);
        return new ResponseEntity<>(userResponseList, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserRequest request) {
        Optional<Long> userId = SecurityUltils.getCurrentUserLoginId();
        UserResponse userResponse = userService.updateUser(userId.get(), request);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteUser() {
        userService.deleteUser();
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}