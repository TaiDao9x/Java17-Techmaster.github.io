package com.example.minitestspringmvc.service;

import com.example.minitestspringmvc.entity.Appointment;
import com.example.minitestspringmvc.entity.User;
import com.example.minitestspringmvc.exception.NotFoundException;
import com.example.minitestspringmvc.model.request.AppointmentRequest;
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

    public AppointmentResponse updateAppointment(Integer id, AppointmentRequest appointmentRequest) throws NotFoundException {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found appointment!"));

        appointment.setStatus(appointmentRequest.getStatus());
        appointmentRepository.save(appointment);
        emailService.sendEmailConfirmAppointment(appointment);
        return objectMapper.convertValue(appointment, AppointmentResponse.class);
    }

    public AppointmentResponse createAppointment(AppointmentRequest appointmentRequest) {
        Appointment appointment;
        User user = userRepository.findByEmail(appointmentRequest.getEmail());
        if (user == null) {
            User newUser = User.builder()
                    .name(appointmentRequest.getName())
                    .email(appointmentRequest.getEmail())
                    .phone(appointmentRequest.getPhone())
                    .build();
            userRepository.save(newUser);
            appointment = Appointment.builder()
                    .user(newUser)
                    .appointmentAt(appointmentRequest.getAppointmentAt())
                    .message(appointmentRequest.getMessage())
                    .build();
            appointmentRepository.save(appointment);
        } else {
            appointment = Appointment.builder()
                    .user(user)
                    .message(appointmentRequest.getMessage())
                    .appointmentAt(appointmentRequest.getAppointmentAt())
                    .build();
            appointmentRepository.save(appointment);
        }
        return objectMapper.convertValue(appointment, AppointmentResponse.class);
    }
}
