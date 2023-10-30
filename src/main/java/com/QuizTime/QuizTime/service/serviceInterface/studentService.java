package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.model.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface studentService {

    List<Student> getStudent();
    Student saveStudent(Student student);

}
