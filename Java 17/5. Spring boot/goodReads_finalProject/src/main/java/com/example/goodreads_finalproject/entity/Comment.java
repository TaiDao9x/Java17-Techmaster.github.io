package com.example.goodreads_finalproject.entity;

import com.example.goodreads_finalproject.statics.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comment extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @OneToOne
    @JoinColumn(name = "book_id")
    Book book;

    @OneToOne
    @JoinColumn(name = "review_id")
    Review review;

    String content;

    Status status;

    LocalDateTime deletedDateTime;
}
