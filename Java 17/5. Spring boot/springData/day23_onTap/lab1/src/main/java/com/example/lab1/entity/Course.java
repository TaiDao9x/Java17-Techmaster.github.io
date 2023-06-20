package com.example.lab1.entity;


import com.example.lab1.statics.TypeStudy;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "typeStudy", nullable = false)
    TypeStudy typeStudy;

    @Column(name = "thumbnail")
    String thumbnail;

    @ManyToOne
    @JoinColumn(name = "supporter_id")
    Supporter supporter;

    @ManyToMany
    @JoinTable(
            name = "topic_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id")
    )
    List<Topic> topics;
}
