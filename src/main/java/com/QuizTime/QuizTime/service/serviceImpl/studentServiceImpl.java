package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.model.entity.Student;
import com.QuizTime.QuizTime.repository.studentRepository;
import com.QuizTime.QuizTime.service.serviceInterface.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class studentServiceImpl implements studentService {

    @Autowired
    private studentRepository studentRepo;

    @Override
    public List<Student> getStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }
}
