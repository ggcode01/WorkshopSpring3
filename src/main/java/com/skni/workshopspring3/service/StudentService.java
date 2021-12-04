package com.skni.workshopspring3.service;

import com.skni.workshopspring3.repo.StudentRepository;
import com.skni.workshopspring3.repo.entity.Course;
import com.skni.workshopspring3.repo.entity.CourseTypeEnum;
import com.skni.workshopspring3.repo.entity.GenderEnum;
import com.skni.workshopspring3.repo.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student addStudent(String name, String lastName, LocalDate birtDate, GenderEnum gender, Course course) {
        Student student = Student.builder()
                .name(name)
                .lastName(lastName)
                .birthDate(birtDate)
                .gender(gender)
                .course(course)
                .build();

        return studentRepository.save(student);
    }

    public boolean deleteStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.delete(student.get());
            return true;
        }
        return false;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> findAllByLastName(String lastName) {
        return studentRepository.findAllByLastName(lastName);
    }

    public List<Student> getStudentByGenderAndByCourseType(GenderEnum gender, CourseTypeEnum courseType) {
        return studentRepository.findAllByGenderAndCourseType(gender.toString(), courseType.toString());
    }

    public List<Student> getStudentByGenderAndBySchool(GenderEnum gender, String school) {
        return studentRepository.findAllByGenderAndSchool(gender.toString(), school);
    }
}