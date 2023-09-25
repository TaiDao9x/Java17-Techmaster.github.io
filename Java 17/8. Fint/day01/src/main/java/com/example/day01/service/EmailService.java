package com.example.day01.service;

import com.example.day01.entity.User;
import com.example.day01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    UserRepository userRepository;

    @Value("${spring.mail.username}")
    private String sender;

    @Async
    public void sendOtp(String email) {
        String otpCode = UUID.randomUUID().toString();
        Optional<User> emailOptional = userRepository.findByEmail(email);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(email);

            mimeMessageHelper.setSubject("[FINT-SOFT] Register user");

            String resetLink = "http://localhost:8080/check-otp-reset?otpCode=" + otpCode;
            String htmlContent = "<html> Bạn vừa đăng ký tài khoản? <a href=\"" + resetLink + "\">Active account.</a>\n " +
                    "\n" +
                    "Email này chỉ có hiệu lực trong vòng 10 phút. Nếu đã quá thời gian vui lòng gửi lại yêu cầu.</html>";
            mimeMessageHelper.setText(htmlContent, true);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            System.out.println("Error while sending mail!!!");
        }
    }
}
