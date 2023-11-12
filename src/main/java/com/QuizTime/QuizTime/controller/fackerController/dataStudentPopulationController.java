package com.QuizTime.QuizTime.controller.fackerController;

import com.QuizTime.QuizTime.datafacker.fackerStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/populate-data-students")
public class dataStudentPopulationController {

    private final fackerStudent studentFacker;

    @Autowired
    public dataStudentPopulationController(fackerStudent studentFacker) {
        this.studentFacker = studentFacker;
    }

    @GetMapping
    public String populateData()
    {
        studentFacker.populateStudentsWithFackerData(5);
        return "Fake data students has been populated!";
    }


}
