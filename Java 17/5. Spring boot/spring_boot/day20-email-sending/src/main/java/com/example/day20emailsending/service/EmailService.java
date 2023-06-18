package com.example.day20emailsending.service;

import com.example.day20emailsending.model.request.EmailDetails;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Random;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    Random rd = new Random();

    public void sendOtp(String email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setTo(email);
        int randomOTP = rd.nextInt(1000000);
        simpleMailMessage.setText("Mã OTP của bạn là: " + randomOTP + "\n\n Không chia sẻ mã này cho bất kỳ ai!");
        simpleMailMessage.setSubject("[Techmaster] OTP Vefification");

        javaMailSender.send(simpleMailMessage);
    }

    public void sendAttachFileEmail(String email) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setText("Email có đính kèm file");
            mimeMessageHelper.setSubject("[DEMO MAIL] Gửi mail kèm file");

            FileSystemResource file = new FileSystemResource(new File("/Users/WIN 10/OneDrive - QUANG TRUNG COLLEGE/BO DEP ZAI/Coding Techmaster/TaiDao9x.github.io/Java 17/avatarTai.jpg"));
            mimeMessageHelper.addAttachment(file.getFilename(), file);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            System.out.println("Error while sending mail!!!");
        }

    }

    public void sendAttachFileEmail2(EmailDetails emailDetails) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(emailDetails.getRecipient());
            mimeMessageHelper.setText("Email có đính kèm file");
            mimeMessageHelper.setSubject("[DEMO MAIL] Gửi mail kèm file");

            FileSystemResource file = new FileSystemResource("/Users/WIN 10/OneDrive - QUANG TRUNG COLLEGE/BO DEP ZAI/Coding Techmaster/TaiDao9x.github.io/Java 17/" +@S emailDetails.getAttachment());
            mimeMessageHelper.addAttachment(file.getFilename(), file);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            System.out.println("Error while sending mail!!!");
        }

    }
}
