package com.example.goodreads_finalproject.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book extends BaseEntity {
    String image;

    String title;

    @OneToMany
    @JoinColumn(name = "category_id")
    Set<Category> categories;

    String author;

    String description;

    @Column(nullable = false)
    double rating;

    LocalDate published;
}
