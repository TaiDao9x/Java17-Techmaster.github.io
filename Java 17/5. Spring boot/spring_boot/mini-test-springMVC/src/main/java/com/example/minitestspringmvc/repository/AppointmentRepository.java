package com.example.minitestspringmvc.repository;

import com.example.minitestspringmvc.entity.Appointment;
import com.example.minitestspringmvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
