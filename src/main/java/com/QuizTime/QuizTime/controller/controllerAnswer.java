package com.QuizTime.QuizTime.controller;


import com.QuizTime.QuizTime.exception.ExceptionAnswer;
import com.QuizTime.QuizTime.model.entity.dto.AnswerDTO;
import com.QuizTime.QuizTime.service.serviceImpl.validationServiceImpl;
import com.QuizTime.QuizTime.service.serviceInterface.answerService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
@CrossOrigin
public class controllerAnswer {

    @Autowired
    private answerService ServiceAnswer;

    @Autowired
    private validationServiceImpl validationService;

    @Autowired
    private ModelMapper modelMapper;



    @GetMapping
    public List<AnswerDTO> getAllAnswers() {
        return ServiceAnswer.getAllAnswers();
    }


    @PostMapping
    public AnswerDTO saveAnswer(@Valid @RequestBody AnswerDTO answer) {
        return ServiceAnswer.saveAnswer(answer);
    }



    @DeleteMapping("/{answerId}")
    public void deleteAnswer(@PathVariable("answerId") Long id) {
        ServiceAnswer.deleteAnswer(id);
    }

    @PutMapping("/{answerId}")
    @CrossOrigin
    public AnswerDTO updateAnswer(@Valid @RequestBody AnswerDTO answer, @PathVariable("answerId") Long id) throws ExceptionAnswer {
        return ServiceAnswer.updateAnswer(answer, id);
    }

    @GetMapping("/{answerId}")
    public AnswerDTO getOneAnswer(@PathVariable("answerId") long id) throws ExceptionAnswer {
        return ServiceAnswer.findByID(id);
    }

}
