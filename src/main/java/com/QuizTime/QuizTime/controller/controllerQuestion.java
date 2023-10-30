package com.QuizTime.QuizTime.controller;

import com.QuizTime.QuizTime.model.entity.Question;
import com.QuizTime.QuizTime.model.entity.Student;
import com.QuizTime.QuizTime.service.serviceInterface.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class controllerQuestion {

    @Autowired
    private questionService ServiceQues;


    @PostMapping("/newQuestion")
    public Question saveQuestion(@RequestBody Question question){
        return ServiceQues.saveQuestion(question);
    }

    @PutMapping("/Questions")
    public Question updateQuestion(@RequestBody Question question){
        ServiceQues.saveQuestion(question);
        return question;
    }

    @DeleteMapping("/{questionId}")
    public void deleteQuestion(@PathVariable("questionId") long id) {
        ServiceQues.deleteQuestion(id);
        return;
    }

}
