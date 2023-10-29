package com.QuizTime.QuizTime.controller.fackerController;

import com.QuizTime.QuizTime.datafacker.fackerTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/population-data-teachers")
public class dataTeacherPopulationController {

    private final fackerTeacher teacherFacker;

    @Autowired
    public dataTeacherPopulationController(fackerTeacher teacherFacker) {
        this.teacherFacker = teacherFacker;
    }

    @GetMapping
    public String populationData()
    {
        teacherFacker.populateTeachersWithFackerData(4);
        return "Fake data teachers has been populated!";
    }

}
