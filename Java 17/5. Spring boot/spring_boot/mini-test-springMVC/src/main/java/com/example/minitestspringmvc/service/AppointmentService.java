package com.example.minitestspringmvc.service;

import com.example.minitestspringmvc.entity.Appointment;
import com.example.minitestspringmvc.exception.NotFoundException;
import com.example.minitestspringmvc.model.request.AppointmentResquest;
import com.example.minitestspringmvc.model.response.AppointmentResponse;
import com.example.minitestspringmvc.repository.AppointmentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentService {
    ObjectMapper objectMapper;
    AppointmentRepository appointmentRepository;

    public AppointmentResponse updateAppointment(Integer id, AppointmentResquest appointmentResquest) throws NotFoundException {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found appointment!"));

        appointment.setDescription(appointmentResquest.getDescription());
        appointment.setStatus(appointmentResquest.getStatus());
        appointmentRepository.save(appointment);
        return objectMapper.convertValue(appointment, AppointmentResponse.class);
    }
}
