package com.example.day20emailsending.controller;

import com.example.day20emailsending.model.request.EmailDetails;
import com.example.day20emailsending.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class UserController {
    UserService userService;

    @PostMapping("/{email}/otp-sending")
    public void sendOtp(@PathVariable String email) {
        userService.sendOtp(email);
    }

    @PostMapping("/{email}/attach-file")
    public void sendAttachFileEmail(@PathVariable String email) {
        userService.sendAttachFileEmail(email);
    }

    @PostMapping("/attach-file")
    public void sendAttachFileEmail(@RequestBody EmailDetails details) {
        userService.sendAttachFileEmail2(details);
    }
}
