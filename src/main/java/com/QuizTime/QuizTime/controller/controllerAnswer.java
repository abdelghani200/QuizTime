package com.QuizTime.QuizTime.controller;

import com.QuizTime.QuizTime.model.entity.Answer;
import com.QuizTime.QuizTime.service.serviceInterface.answerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class controllerAnswer {

    @Autowired
    private answerService ServiceAnswer;

    @GetMapping("/answers")
    public List<Answer> getAllAnswers() {
        return ServiceAnswer.getAllAnswers();
    }

    @PostMapping("/answers")
    public Answer saveAnswer(@RequestBody Answer answer) {
        return ServiceAnswer.saveAnswer(answer);
    }

}
