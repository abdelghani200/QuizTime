package com.QuizTime.QuizTime.controller;

import com.QuizTime.QuizTime.model.entity.Student;
import com.QuizTime.QuizTime.service.serviceInterface.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class controllerStudent {

    @Autowired
    private studentService serviceStudent;
    @GetMapping("/listeStudent")
    public List<Student> getAllStudent(){
        return serviceStudent.getStudent();
    }

    @PostMapping("/newStudent")
    public Student saveStudent(@RequestBody Student student) {
        return serviceStudent.saveStudent(student);
    }

}
