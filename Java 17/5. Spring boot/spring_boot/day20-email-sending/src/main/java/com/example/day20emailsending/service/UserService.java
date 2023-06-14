package com.example.day20emailsending.service;

import com.example.day20emailsending.model.request.EmailDetails;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService {
    EmailService emailService;

    public void sendOtp(String email) {
        emailService.sendOtp(email);
    }

    public void sendAttachFileEmail(String email) {
        emailService.sendAttachFileEmail(email);
    }

    public void sendAttachFileEmail2(EmailDetails details) {
        emailService.sendAttachFileEmail2(details);
    }
}
