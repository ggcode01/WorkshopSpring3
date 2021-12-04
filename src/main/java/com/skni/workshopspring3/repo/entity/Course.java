package com.skni.workshopspring3.repo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "term")
    private Integer term;

    @Column(name = "school")
    private String school;

    @Enumerated(EnumType.STRING)
    @Column(name = "coursetype")
    private CourseTypeEnum courseType;
}