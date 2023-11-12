package com.QuizTime.QuizTime.controller;

import com.QuizTime.QuizTime.exception.ExceptionAnswer;
import com.QuizTime.QuizTime.model.entity.Answer;
import com.QuizTime.QuizTime.service.serviceInterface.answerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
@CrossOrigin
public class controllerAnswer {

    @Autowired
    private answerService ServiceAnswer;

    @GetMapping
    public List<Answer> getAllAnswers() {
        return ServiceAnswer.getAllAnswers();
    }

    @PostMapping
    public Answer saveAnswer(@RequestBody Answer answer) {
        return ServiceAnswer.saveAnswer(answer);
    }

    @DeleteMapping("/{answerId}")
    public void deleteAnswer(@PathVariable("answerId") Long id) {
        ServiceAnswer.deleteAnswer(id);
    }

    @PutMapping("/{answerId}")
    public Answer updateAnswer(@RequestBody Answer answer, @PathVariable("answerId") Long id) throws ExceptionAnswer {
        return ServiceAnswer.updateAnswer(answer, id);
    }

}
