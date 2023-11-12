package com.QuizTime.QuizTime.controller;

import com.QuizTime.QuizTime.model.entity.Question;
import com.QuizTime.QuizTime.model.entity.dto.QuestionDTO;
import com.QuizTime.QuizTime.service.serviceInterface.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/questions")
@CrossOrigin
public class controllerQuestion {

    @Autowired
    private questionService ServiceQues;


    @GetMapping
    public List<QuestionDTO> getAllQuestions(){
        return ServiceQues.getAllQuestions();
    }

    @PostMapping
    public QuestionDTO saveQuestion(@RequestBody QuestionDTO question) {
        return ServiceQues.saveQuestion(question);
    }


    @PutMapping
    public QuestionDTO updateQuestion(@RequestBody QuestionDTO question){
        ServiceQues.saveQuestion(question);
        return question;
    }

    @DeleteMapping("/{questionId}")
    public void deleteQuestion(@PathVariable("questionId") long id) {
        ServiceQues.deleteQuestion(id);
        return;
    }


    @GetMapping("/{questionId}")
    public Optional<Question> getOneQuestion(@PathVariable("questionId") long id){
        return ServiceQues.getOne(id);
    }


}
