package com.QuizTime.QuizTime.controller;

import com.QuizTime.QuizTime.helpers.MediaResDTO;
import com.QuizTime.QuizTime.helpers.QuestionResDTO;
import com.QuizTime.QuizTime.helpers.TempoQuestionRes;
import com.QuizTime.QuizTime.model.entity.dto.*;
import com.QuizTime.QuizTime.exception.ExceptionQuestion;
import com.QuizTime.QuizTime.service.serviceInterface.questionService;
import com.QuizTime.QuizTime.service.serviceInterface.questionTempo;
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

    @Autowired
    private questionTempo TempoQuestion;

    @GetMapping()
    public List<QuestionDTO> getAll() {
        return ServiceQues.AllQuestions();
    }

    @PostMapping
    public QuestionResDTO saveQuestion(@Valid @RequestBody QuestionResDTO question) {
        return ServiceQues.saveQuestion(question);
    }


    @PutMapping("/{questionId}")
    public QuestionResDTO updateQuestion(@PathVariable("questionId") Long id, @Valid @RequestBody QuestionResDTO question){
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

    @GetMapping("/medias")
    public List<MediaResDTO> getAllMedia() {
        return ServiceQues.getAllMedia();
    }


    @PostMapping("/tempo")
    public QuestionTempoDTO  saveTempoQuestion(@Valid @RequestBody QuestionTempoDTO questionTempoDTO) {
        return TempoQuestion.saveTempoQuestion(questionTempoDTO);
    }

    @GetMapping("/tempo")
    public List<TempoQuestionRes> getAllTempoQuestions() {
        return TempoQuestion.getAllTempoQuestions();
    }
    @GetMapping("/tempo/{quizID}")
    public List<TempoQuestionRes> getTempoQuestionsForQuiz(@PathVariable("quizID") Long quizID){
        return TempoQuestion.getTempoQuestionsForQuiz(quizID);
    }

}
