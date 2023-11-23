package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.model.entity.Student;
import com.QuizTime.QuizTime.model.entity.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface studentService {

    List<StudentDTO> getStudent();
    Student saveStudent(Student student);

}
