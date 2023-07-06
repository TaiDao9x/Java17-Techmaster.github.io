package com.example.goodreads_finalproject.entity;

import com.example.goodreads_finalproject.statics.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "followings")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Following extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_request_id")
    User userRequest;

    @ManyToOne
    @JoinColumn(name = "user_accept_id")
    User userAccept;

    Status status;

    LocalDateTime acceptedDateTime;
}
