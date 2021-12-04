package com.skni.workshopspring3.service;

import com.skni.workshopspring3.repo.CourseRepository;
import com.skni.workshopspring3.repo.entity.Course;
import com.skni.workshopspring3.repo.entity.CourseTypeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course addCourse(String name, Integer term, String school, CourseTypeEnum courseType) {
        Course course = Course.builder()
                .name(name)
                .term(term)
                .school(school)
                .courseType(courseType)
                .build();

        return courseRepository.save(course);
    }
}