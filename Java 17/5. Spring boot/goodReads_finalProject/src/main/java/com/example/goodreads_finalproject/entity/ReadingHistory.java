package com.example.goodreads_finalproject.entity;

import com.example.goodreads_finalproject.statics.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReadingHistory extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;

    @Enumerated(EnumType.STRING)
    Status status;

    @Column(nullable = false)
    double readingProgress;

    LocalDateTime startedDateTime;

    LocalDateTime finishedDateTime;

    LocalDateTime deletedDateTime;
}
