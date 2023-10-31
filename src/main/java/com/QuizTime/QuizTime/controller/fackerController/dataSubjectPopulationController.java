package com.QuizTime.QuizTime.controller.fackerController;

import com.QuizTime.QuizTime.datafacker.fackerSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/populate-data-subjects")
public class dataSubjectPopulationController {


    @Autowired
    private fackerSubject subjectDataFaker;

    @GetMapping
    public String populateData() {
        subjectDataFaker.populateSubjectData();
        return "Fake data subjects have been populated!";
    }

}
