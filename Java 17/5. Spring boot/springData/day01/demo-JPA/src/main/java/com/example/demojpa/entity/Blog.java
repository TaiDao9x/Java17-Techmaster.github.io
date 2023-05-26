package com.example.demojpa.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Blog {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(columnDefinition = "VARCHAR(255)", unique = true, nullable = false)
    String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    String description;

    @Column(columnDefinition = "TEXT", nullable = false)
    String content;

    @Column(columnDefinition = "VARCHAR(255)")
    String thumbnail;

    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    ArrayList<String> categories;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    String authorName;

    @Column(nullable = false)
    LocalDateTime createdAt;

    @Column(nullable = false)
    LocalDateTime updatedAt;

    LocalDateTime publishedAt;

//    @Column(nullable = false, columnDefinition = "default 'false'")
    Boolean status;
}
