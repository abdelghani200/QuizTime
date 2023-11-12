package com.QuizTime.QuizTime.controller;

import com.QuizTime.QuizTime.exception.ExceptionLevel;
import com.QuizTime.QuizTime.model.entity.Level;
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
    public List<Level> getAllLevels() {
        return Level_service.getAllLevels();
    }

    @DeleteMapping("/{levelId}")
    public void deleteLevel(@PathVariable("levelId") Long id){
        Level_service.deleteLevel(id);
    }

    @PostMapping()
    public Level saveLevel(@RequestBody Level level) {
        return Level_service.saveLevel(level);
    }

    /*
    @PostMapping
    public ResponseEntity<?> saveLevel(HttpServletRequest request, @RequestBody Level level) {
        String contentType = request.getContentType();

        if (MediaType.APPLICATION_JSON_VALUE.equals(contentType)) {
            Level savedLevel = Level_service.saveLevel(level);
            return ResponseEntity.ok(savedLevel);
        } else {
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("Unsupported Media Type");
        }
    }

     */

    @GetMapping("/{levelId}")
    public Optional<Level> getOneLevel(@PathVariable("levelId") Long id) {
        return Level_service.getOne(id);
    }

    @PutMapping("/{levelId}")
    public Level updateLevel(@PathVariable Long levelId, @RequestBody Level level) throws ExceptionLevel {
        return Level_service.updateLevel(level, levelId);
    }

}
