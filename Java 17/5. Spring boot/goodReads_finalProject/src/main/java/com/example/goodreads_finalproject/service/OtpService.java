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

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

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

//        simpleMailMessage.setText("Mã OTP của bạn là: " + randomOTP + "\n Không chia sẻ mã này cho bất kỳ ai!");
        simpleMailMessage.setText("<html><body><a href='#'>Click here</a></body></html>");
        simpleMailMessage.setSubject("[Goodreads] OTP reset password");


        javaMailSender.send(simpleMailMessage);

        Optional<User> emailOptional = userRepository.findByEmail(email);

        otpRepository.save(Otp.builder()
                .otpCode(randomOTP)
                .user(emailOptional.get())
                .expiredAt(LocalDateTime.now().plusSeconds(120))
                .build());


    }

    public void sendOtpActivedAccount(String email) {
        String otpCode = UUID.randomUUID().toString();
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(email);

            mimeMessageHelper.setSubject("[Goodreads] Active account");
            String htmlContent = "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                    "\n" +
                    "<head>\n" +
                    "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                    "  <meta name=\"x-apple-disable-message-reformatting\" />\n" +
                    "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                    "  <meta name=\"color-scheme\" content=\"light dark\" />\n" +
                    "  <meta name=\"supported-color-schemes\" content=\"light dark\" />\n" +
                    "  <title></title>\n" +
                    "  \n" +
                    "</head>\n" +
                    "\n" +
                    "<body>\n" +
                    "  <table class=\"email-wrapper\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\">\n" +
                    "    <tr>\n" +
                    "      <td align=\"center\">\n" +
                    "        <table class=\"email-content\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\">\n" +
                    "          <tr>\n" +
                    "            <td class=\"email-masthead\">\n" +
                    "              <p>Welcome to <Strong>GoodReads.</Strong></p>\n" +
                    "              <a href=\"http://localhost:8080/actived/" + otpCode + "\" target=\"_blank\" >\n" +
                    "                Active your Account\n" +
                    "              </a>\n" +
                    "\n" +
                    "            </td>\n" +
                    "          </tr>\n" +
                    "          \n" +
                    "          <tr>\n" +
                    "            <td>\n" +
                    "              <table class=\"email-footer\" align=\"center\" width=\"570\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                    "                role=\"presentation\">\n" +
                    "                <tr>\n" +
                    "                  <td class=\"content-cell\" align=\"center\">\n" +
                    "                    <p class=\"f-fallback sub align-center\">\n" +
                    "                      [Techmaster, LLC]\n" +
                    "                      <br>Dich Vong Hau Street, Ha Noi city.\n" +
                    "                      <br>Tai Dao, Java 17\n" +
                    "                    </p>\n" +
                    "                  </td>\n" +
                    "                </tr>\n" +
                    "              </table>\n" +
                    "            </td>\n" +
                    "          </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </table>\n" +
                    "</body>\n" +
                    "\n" +
                    "</html>";
            mimeMessageHelper.setText(htmlContent, true);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            System.out.println("Error while sending mail!!!");
        }

        Optional<User> emailOptional = userRepository.findByEmail(email);

        otpRepository.save(Otp.builder()
                .otpCode(otpCode)
                .user(emailOptional.get())
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
