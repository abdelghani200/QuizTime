package com.QuizTime.QuizTime.controller;


import com.QuizTime.QuizTime.helpers.SubjectResDTO;
import com.QuizTime.QuizTime.model.entity.dto.SubjectDTO;
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
    public List<SubjectResDTO> getAllSubjects() {
        return ServiceSubject.getAllSubjects();
    }

    @PostMapping()
    public SubjectDTO saveSubject(@RequestBody SubjectDTO subject) {
        return ServiceSubject.createSubject(subject);
    }

    @DeleteMapping("/{subjectId}")
    public void deleteSubject(@PathVariable("subjectId") Integer id) {
        ServiceSubject.deleteSubject(id);
    }

    @PutMapping("/{subjectId}")
    public SubjectDTO updateSubject(@PathVariable("subjectId") Integer id, @RequestBody SubjectDTO subject) {
        return ServiceSubject.updateSubject(subject, id);
    }

}
