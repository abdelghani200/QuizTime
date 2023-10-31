package com.QuizTime.QuizTime.controller;

import com.QuizTime.QuizTime.exception.ExceptionLevel;
import com.QuizTime.QuizTime.model.entity.Level;
import com.QuizTime.QuizTime.service.serviceInterface.levelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class controllerLevel {

    @Autowired
    private levelService Level_service;

    @GetMapping("/levels")
    public List<Level> getAllLevels() {
        return Level_service.getAllLevels();
    }

    @DeleteMapping("/level/{levelId}")
    public void deleteLevel(@PathVariable("levelId") Integer id){
        Level_service.deleteLevel(id);
    }

    @PostMapping("/newLevel")
    public Level saveLevel(@RequestBody Level level) {
        return Level_service.saveLevel(level);
    }

    @GetMapping("/level/{levelId}")
    public Optional<Level> getOneLevel(@PathVariable("levelId") Integer id) {
        return Level_service.getOne(id);
    }

    @PutMapping("/level/{levelId}")
    public Level updateLevel(@PathVariable Integer levelId, @RequestBody Level level) throws ExceptionLevel {
        return Level_service.updateLevel(level, levelId);
    }

}
