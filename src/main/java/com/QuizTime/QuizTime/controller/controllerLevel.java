package com.QuizTime.QuizTime.controller;

import com.QuizTime.QuizTime.model.entity.Level;
import com.QuizTime.QuizTime.service.serviceInterface.levelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class controllerLevel {

    @Autowired
    private levelService Level_service;

    @GetMapping("/levels")
    public List<Level> getAllLevels() {
        return Level_service.getAllLevels();
    }

}
