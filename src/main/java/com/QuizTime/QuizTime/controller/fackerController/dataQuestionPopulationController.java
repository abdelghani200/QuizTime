package com.QuizTime.QuizTime.controller.fackerController;

import com.QuizTime.QuizTime.datafacker.fackerStudent;
import com.QuizTime.QuizTime.datafacker.fakerQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/population-data-questions")
public class dataQuestionPopulationController {


    private final fakerQuestion questionFacker;

    @Autowired
    public dataQuestionPopulationController(fakerQuestion questionFacker) {
        this.questionFacker = questionFacker;
    }

    @GetMapping
    public String populateData()
    {
        questionFacker.populateQuestionsWithFakerData(8);
        return "Fake data questions has been populated!";
    }


}
