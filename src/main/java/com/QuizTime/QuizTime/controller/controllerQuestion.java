package com.QuizTime.QuizTime.controller;

import com.QuizTime.QuizTime.model.entity.dto.AnswerQuestionDTO;
import com.QuizTime.QuizTime.exception.ExceptionQuestion;
import com.QuizTime.QuizTime.model.entity.dto.QuestionDTO;
import com.QuizTime.QuizTime.service.serviceInterface.questionService;
import jakarta.validation.Valid;
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
    public List<QuestionDTO> getAllQuestions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ServiceQues.getAllQuestions(page, size);
    }

    @PostMapping
    public QuestionDTO saveQuestion(@Valid @RequestBody QuestionDTO question) {
        return ServiceQues.saveQuestion(question);
    }


    @PutMapping("/{questionId}")
    public QuestionDTO updateQuestion(@PathVariable("questionId") Long id, @Valid @RequestBody QuestionDTO question){
        ServiceQues.updateQuestion(question, id);
        return question;
    }

    @DeleteMapping("/{questionId}")
    public void deleteQuestion(@PathVariable("questionId") long id) {
        ServiceQues.deleteQuestion(id);
        return;
    }


    @GetMapping("/{questionId}")
    public AnswerQuestionDTO getOneQuestion(@PathVariable("questionId") long id) throws ExceptionQuestion {
        return ServiceQues.findByID(id);
    }


}
