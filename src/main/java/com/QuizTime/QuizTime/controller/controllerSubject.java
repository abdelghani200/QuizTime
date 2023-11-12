package com.QuizTime.QuizTime.controller;

import com.QuizTime.QuizTime.exception.ExceptionSubject;
import com.QuizTime.QuizTime.model.entity.Subject;
import com.QuizTime.QuizTime.service.serviceInterface.subjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@CrossOrigin
public class controllerSubject {

    @Autowired
    private subjectService ServiceSubject;

    @GetMapping()
    public List<Subject> getAllSubjects() {
        return ServiceSubject.getAllSubjects();
    }

    @PostMapping()
    public Subject saveSubject(@RequestBody Subject subject) {
        return ServiceSubject.saveSubject(subject);
    }

    @DeleteMapping("/{subjectId}")
    public void deleteSubject(@PathVariable("subjectId") Integer id) {
        ServiceSubject.deleteSubject(id);
    }

    @PutMapping("/{subjectId}")
    public Subject updateSubject(@PathVariable("subjectId") Integer id, @RequestBody Subject subject) throws ExceptionSubject {
        return ServiceSubject.updateSubject(subject, id);
    }

}
