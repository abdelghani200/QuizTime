package com.QuizTime.QuizTime.controller.fackerController;

import com.QuizTime.QuizTime.datafacker.fackerAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/population-data-answers")
public class dataAnswerPopulationController {


    private final fackerAnswer answerFacker;

    @Autowired
    public dataAnswerPopulationController(fackerAnswer answerFacker) {
        this.answerFacker = answerFacker;
    }

    @GetMapping
    public String populateData()
    {
        answerFacker.populateAnswersWithFakerData();
        return "Fake data students has been populated!";
    }


}
