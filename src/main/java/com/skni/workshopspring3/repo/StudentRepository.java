package com.skni.workshopspring3.repo;

import com.skni.workshopspring3.repo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Override
    List<Student> findAll();

    List<Student> findAllByLastName (String lastName);

    @Query(
            value = "SELECT * FROM student s JOIN course c ON s.course_id = c.id WHERE s.gender = ?1 AND c.coursetype = ?2",
            nativeQuery = true
    )
    List<Student> findAllByGenderAndCourseType (String gender, String courseType);

    @Query(
            value = "SELECT * FROM student s JOIN course c ON s.course_id = c.id WHERE s.gender = ?1 AND c.school = ?2",
            nativeQuery = true
    )
    List<Student> findAllByGenderAndSchool (String gender, String school);
}
