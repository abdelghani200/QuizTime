package com.QuizTime.QuizTime.controller;

import com.QuizTime.QuizTime.exception.ExceptionLevel;
import com.QuizTime.QuizTime.model.entity.Level;
import com.QuizTime.QuizTime.model.entity.dto.LevelDTO;
import com.QuizTime.QuizTime.service.serviceInterface.levelService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/levels")
@CrossOrigin
public class controllerLevel {

    @Autowired
    private levelService Level_service;

    @GetMapping
    public List<LevelDTO> getAllLevels() {
        return Level_service.getAllLevels();
    }

    @DeleteMapping("/{levelId}")
    public void deleteLevel(@PathVariable("levelId") Long id){
        Level_service.deleteLevel(id);
    }

    @PostMapping()
    public LevelDTO saveLevel(@RequestBody LevelDTO level) {
        return Level_service.saveLevel(level);
    }


    @GetMapping("/{levelId}")
    public Optional<LevelDTO> getOneLevel(@PathVariable("levelId") Long id) {
        return Level_service.getById(id);
    }

    @PutMapping("/{levelId}")
    @CrossOrigin
    public LevelDTO updateLevel(@PathVariable Long levelId, @RequestBody LevelDTO level) throws ExceptionLevel {
        return Level_service.updateLevel(level, levelId);
    }

}
