package com.QuizTime.QuizTime.controller;


import com.QuizTime.QuizTime.helpers.ValidationRes;
import com.QuizTime.QuizTime.model.entity.dto.AnswerQuestionDTO;
import com.QuizTime.QuizTime.model.entity.dto.ValidationDTO;
import com.QuizTime.QuizTime.service.serviceInterface.answerService;
import com.QuizTime.QuizTime.service.serviceInterface.questionService;
import com.QuizTime.QuizTime.service.serviceInterface.validationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping(value = "/validations")
@CrossOrigin
public class controllerValidation {

    @Autowired
    private validationService validationService;

    @Autowired
    private answerService serviceAnswer;

    @Autowired
    private questionService serviceQuestion;


    @PostMapping
    public ResponseEntity<ValidationDTO> createValidation( @RequestBody ValidationDTO validationDto) throws Exception {
        ValidationDTO savedValidationDto = validationService.save(validationDto);
        return ResponseEntity.ok(savedValidationDto);
    }

    @GetMapping
    public List<ValidationRes> getAllValidation(){
        return validationService.getValidations();
    }


}
