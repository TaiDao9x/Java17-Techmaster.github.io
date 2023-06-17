package com.example.minitestspringmvc.entity;

import com.example.minitestspringmvc.statics.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer id;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "description")
    String description;

    @Column(name = "status")
    Status status;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    @Column(name = "confirm_at")
    LocalDateTime confirmAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.status = Status.UNCONFIRMED;
    }

    @PreUpdate
    public void preUpdate() {
        this.confirmAt = LocalDateTime.now();
    }
}
