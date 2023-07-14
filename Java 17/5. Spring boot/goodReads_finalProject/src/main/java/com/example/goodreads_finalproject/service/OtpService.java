package com.example.goodreads_finalproject.service;

import com.example.goodreads_finalproject.entity.Otp;
import com.example.goodreads_finalproject.entity.User;
import com.example.goodreads_finalproject.model.request.EmailDetails;
import com.example.goodreads_finalproject.repository.OtpRepository;
import com.example.goodreads_finalproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;

@Service
public class OtpService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    OtpRepository otpRepository;
    @Autowired
    UserRepository userRepository;

    @Value("${spring.mail.username}")
    private String sender;

    Random rd = new Random();

    public void sendOtp(String email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setTo(email);

        String randomOTP = String.valueOf(rd.nextInt(100000));

        simpleMailMessage.setText("Mã OTP của bạn là: " + randomOTP + "\n Không chia sẻ mã này cho bất kỳ ai!");
        simpleMailMessage.setSubject("[Goodreads] OTP reset password");


        javaMailSender.send(simpleMailMessage);

        Optional<User> emailOptional = userRepository.findByEmail(email);

        otpRepository.save(Otp.builder()
                .otpCode(randomOTP)
                .user(emailOptional.get())
                .expiredAt(LocalDateTime.now().plusSeconds(120))
                .build());
    }

//    public void sendAttachFileEmail(String email) {
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//
//        try {
//            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//
//            mimeMessageHelper.setFrom(sender);
//            mimeMessageHelper.setTo(email);
//            mimeMessageHelper.setText("Email có đính kèm file");
//            mimeMessageHelper.setSubject("[DEMO MAIL] Gửi mail kèm file");
//
//            FileSystemResource file = new FileSystemResource(new File("/Users/WIN 10/OneDrive - QUANG TRUNG COLLEGE/BO DEP ZAI/Coding Techmaster/TaiDao9x.github.io/Java 17/avatarTai.jpg"));
//            mimeMessageHelper.addAttachment(file.getFilename(), file);
//
//            javaMailSender.send(mimeMessage);
//        } catch (MessagingException e) {
//            System.out.println("Error while sending mail!!!");
//        }
//
//    }
//
//    public void sendAttachFileEmail2(EmailDetails emailDetails) {
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//
//        try {
//            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//
//            mimeMessageHelper.setFrom(sender);
//            mimeMessageHelper.setTo(emailDetails.getRecipient());
//            mimeMessageHelper.setText("Email có đính kèm file");
//            mimeMessageHelper.setSubject("[DEMO MAIL] Gửi mail kèm file");
//
//            FileSystemResource file = new FileSystemResource("/Users/WIN 10/OneDrive - QUANG TRUNG COLLEGE/BO DEP ZAI/Coding Techmaster/TaiDao9x.github.io/Java 17/" +@S emailDetails.getAttachment());
//            mimeMessageHelper.addAttachment(file.getFilename(), file);
//
//            javaMailSender.send(mimeMessage);
//        } catch (MessagingException e) {
//            System.out.println("Error while sending mail!!!");
//        }
//
//    }
}
