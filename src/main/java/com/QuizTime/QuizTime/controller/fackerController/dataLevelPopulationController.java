package com.QuizTime.QuizTime.controller.fackerController;

import com.QuizTime.QuizTime.datafacker.fackerLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/populate-data-levels")
public class dataLevelPopulationController {

    private final fackerLevel levelFacker;

    @Autowired
    public dataLevelPopulationController(fackerLevel levelFacker) {
        this.levelFacker = levelFacker;
    }

    @GetMapping
    public String populateData()
    {
        levelFacker.populateLevelsWithFackerData(3);
        return "Fake data levels has been populated!";
    }

}
