package com.example.minitestspringmvc.service;

import com.example.minitestspringmvc.entity.Appointment;
import com.example.minitestspringmvc.entity.User;
import com.example.minitestspringmvc.exception.NotFoundException;
import com.example.minitestspringmvc.model.request.AppointmentResquest;
import com.example.minitestspringmvc.model.response.AppointmentResponse;
import com.example.minitestspringmvc.repository.AppointmentRepository;
import com.example.minitestspringmvc.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentService {
    ObjectMapper objectMapper;
    AppointmentRepository appointmentRepository;
    EmailService emailService;
    UserRepository userRepository;

    public AppointmentResponse updateAppointment(Integer id, AppointmentResquest appointmentResquest) throws NotFoundException {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found appointment!"));

        appointment.setStatus(appointmentResquest.getStatus());
        appointmentRepository.save(appointment);
        emailService.sendEmailConfirmAppointment(appointment);
        return objectMapper.convertValue(appointment, AppointmentResponse.class);
    }

    public AppointmentResponse createAppointment(AppointmentResquest appointmentResquest) {
        Appointment appointment;
        User user = userRepository.findByEmail(appointmentResquest.getEmail());
        if (user == null) {
            User newUser = User.builder()
                    .name(appointmentResquest.getName())
                    .email(appointmentResquest.getEmail())
                    .phone(appointmentResquest.getPhone())
                    .build();
            userRepository.save(newUser);
            appointment = Appointment.builder()
                    .user(newUser)
                    .appointmentAt(appointmentResquest.getAppointmentAt())
                    .message(appointmentResquest.getMessage())
                    .build();
            appointmentRepository.save(appointment);
        } else {
            appointment = Appointment.builder()
                    .user(user)
                    .message(appointmentResquest.getMessage())
                    .appointmentAt(appointmentResquest.getAppointmentAt())
                    .build();
            appointmentRepository.save(appointment);
        }
        return objectMapper.convertValue(appointment, AppointmentResponse.class);
    }
}
