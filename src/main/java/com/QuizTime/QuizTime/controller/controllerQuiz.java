package com.QuizTime.QuizTime.controller;

import com.QuizTime.QuizTime.exception.ExceptionLevel;
import com.QuizTime.QuizTime.model.entity.dto.AnswerQuestionDTO;
import com.QuizTime.QuizTime.model.entity.dto.LevelDTO;
import com.QuizTime.QuizTime.model.entity.dto.QuizDTO;
import com.QuizTime.QuizTime.service.serviceInterface.quizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/quiz")
public class controllerQuiz {

    @Autowired
    private quizService ServiceQuiz;

    @PostMapping
    public QuizDTO saveQuiz(@RequestBody QuizDTO quizDTO) {
        return ServiceQuiz.saveQuiz(quizDTO);
    }

    @GetMapping
    public List<QuizDTO> getAllQuiz(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ServiceQuiz.getAllQuiz(page, size);
    }

    @PutMapping("/{quizId}")
    public QuizDTO updateQuiz(@PathVariable Long quizId, @RequestBody QuizDTO quizDTO) {
        return ServiceQuiz.updateQuiz(quizDTO, quizId);
    }

    @GetMapping("/{quizId}")
    public QuizDTO getQuiz(@PathVariable("quizId") long id) {
        return ServiceQuiz.findByID(id);
    }

    @DeleteMapping("/{quizId}")
    public ResponseEntity<QuizDTO> deleteQuiz(@PathVariable("quizId") long id) {
        QuizDTO deletedQuiz = ServiceQuiz.deleteQuiz(id);
        return ResponseEntity.ok(deletedQuiz);
    }

}
