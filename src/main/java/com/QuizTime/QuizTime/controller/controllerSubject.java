package com.QuizTime.QuizTime.controller;

import com.QuizTime.QuizTime.model.entity.Subject;
import com.QuizTime.QuizTime.service.serviceInterface.subjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class controllerSubject {

    @Autowired
    private subjectService ServiceSubject;

    @GetMapping("/subjects")
    public List<Subject> getAllSubjects() {
        return ServiceSubject.getAllSubjects();
    }

    @PostMapping("/subjects")
    public Subject saveSubject(@RequestBody Subject subject) {
        return ServiceSubject.saveSubject(subject);
    }

}
