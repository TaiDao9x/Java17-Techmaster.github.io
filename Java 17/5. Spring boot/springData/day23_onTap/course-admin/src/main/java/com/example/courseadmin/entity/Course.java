package com.example.courseadmin.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

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
    String typeStudy;

    @Column(name = "thumbnail")
    String thumbnail;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supporter_id")
    Supporter supporter;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "topic_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id")
    )
    Set<Topic> topics;
}
