package com.QuizTime.QuizTime.controller;

import com.QuizTime.QuizTime.model.entity.Question;
import com.QuizTime.QuizTime.service.serviceInterface.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class controllerQuestion {

    @Autowired
    private questionService ServiceQues;


    @GetMapping("/listeQuestions")
    public List<Question> getAllQuestions(){
        return ServiceQues.getAll();
    }

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


    @GetMapping("/Question/{questionId}")
    public Optional<Question> getOneQuestion(@PathVariable("questionId") long id){
        return ServiceQues.getOne(id);
    }


}
