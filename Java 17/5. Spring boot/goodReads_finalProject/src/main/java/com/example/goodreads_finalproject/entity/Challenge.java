package com.example.goodreads_finalproject.entity;

import com.example.goodreads_finalproject.statics.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Challenge extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    String typeOfChallenge;

    Integer numberOfBook;

    Status status;

    LocalDateTime startedDateTime;

    LocalDateTime finishedDateTime;

    LocalDateTime deletedDateTime;

}
