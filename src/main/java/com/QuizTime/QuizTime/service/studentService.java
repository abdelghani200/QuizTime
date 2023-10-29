package com.QuizTime.QuizTime.service;

import com.QuizTime.QuizTime.model.entity.Student;
import com.QuizTime.QuizTime.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {

    @Autowired
    private studentRepository studentRepo;

    public List<Student> getStudent(){
        return studentRepo.findAll();
    }

}
