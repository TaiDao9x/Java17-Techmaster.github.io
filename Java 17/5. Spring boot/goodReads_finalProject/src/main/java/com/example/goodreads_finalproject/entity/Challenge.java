package com.example.goodreads_finalproject.entity;

import com.example.goodreads_finalproject.statics.ChallengeStatus;
import com.example.goodreads_finalproject.statics.HistoryStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "challenges")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Challenge extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    String typeOfChallenge;

    Integer numberOfBook;

    @Enumerated(EnumType.STRING)
    ChallengeStatus challengeStatus;

    LocalDateTime startedDateTime;

    LocalDateTime finishedDateTime;

    LocalDateTime deletedDateTime;

}
