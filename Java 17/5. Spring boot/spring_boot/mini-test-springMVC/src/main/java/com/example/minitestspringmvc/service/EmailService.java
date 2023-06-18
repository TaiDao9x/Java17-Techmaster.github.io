package com.example.minitestspringmvc.service;

import com.example.minitestspringmvc.entity.Appointment;
import com.example.minitestspringmvc.entity.Product;
import com.example.minitestspringmvc.exception.NotFoundException;
import com.example.minitestspringmvc.model.request.OrderRequest;
import com.example.minitestspringmvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class EmailService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public void sendEmailOrder(Integer productId, @Valid OrderRequest orderRequest) throws NotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Not found Product!"));

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setTo(orderRequest.getEmail());
        simpleMailMessage.setSubject("[DROOL] Confirm Order");
        simpleMailMessage.setText("Bạn đã đặt sản phẩm: \n - Tên sản phẩm: " + product.getName()
                + "\n - Giá sản phẩm: $" + product.getPrice()
                + "\n - Mô tả: " + product.getDescription()
                + "\n\nThông tin người đặt: \n - Name: " + orderRequest.getName()
                + "\n - Email: " + orderRequest.getEmail()
                + "\n - Phone: " + orderRequest.getPhone()
                + "\n\nCửa hàng đã tiếp nhận đơn của bạn và sẽ gủi đến bạn trong thời gian sớm nhất.\n\nCảm ơn bạn đã tin tưởng và sử dụng dịch vụ của chúng tôi!\n\n---------------------------------");

        javaMailSender.send(simpleMailMessage);
    }

    public void sendEmailConfirmAppointment(Appointment appointment) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setTo(appointment.getUser().getEmail());
        simpleMailMessage.setSubject("[DROOL] Confirm Appointment");

        String status = appointment.getStatus().getName();

        if (status.equals("Approved")) {
            simpleMailMessage.setText("Bạn đã đặt lịch khám cho thú cưng. "
                    + "\n\nThông tin lịch hẹn: \n - Name: " + appointment.getUser().getName()
                    + "\n - Phone: " + appointment.getUser().getPhone()
                    + "\n - Message: " + appointment.getMessage()
                    + "\n- Time: " + appointment.getAppointmentAt()
                    + "\n\nCửa hàng đã tiếp nhận và sắp xếp lịch cho bạn, bạn vui lòng đến cửa hàng trước 5 phút và làm thủ tục ở quầy lễ tân!\n\nCảm ơn bạn đã tin tưởng và sử dụng dịch vụ của chúng tôi!\n\n---------------------------------"
                    + "\n\nTrân trọng.");

            javaMailSender.send(simpleMailMessage);
        } else if (status.equals("Refused")) {
            simpleMailMessage.setText("Bạn đã đặt lịch khám cho thú cưng vào ngày: " + appointment.getAppointmentAt()

                    + "\n\nRất tiếc khi phải thông báo đến bạn rằng hôm đó chúng tôi đã không còn lịch trống. \n\nBạn vui lòng thay đổi lịch khám vào hôm khác.\n\nXin lỗi bạn vì sự bất tiện này.\n\nCảm ơn bạn đã tin tưởng và sử dụng dịch vụ của chúng tôi!\n\n---------------------------------"
                    + "\n\nTrân trọng.");

            javaMailSender.send(simpleMailMessage);
        }


    }
}
