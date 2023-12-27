package com.QuizTime.QuizTime.controller;

import com.QuizTime.QuizTime.model.entity.dto.AssignQuizDTO;
import com.QuizTime.QuizTime.service.serviceInterface.assignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/assign")
@CrossOrigin
public class controllerAssign {

    @Autowired
    private assignService serviceAssign;

    @PostMapping
    public ResponseEntity<List<AssignQuizDTO>> createAssignQuiz(@RequestBody List<AssignQuizDTO> assignQuizDTO) {
        List<AssignQuizDTO> savedAssigns = serviceAssign.saveAssign(assignQuizDTO);
        return new ResponseEntity<>(savedAssigns, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AssignQuizDTO>> getAllAssignQuiz() {
        List<AssignQuizDTO> assignQuizzesDTO = serviceAssign.getAll();
        return new ResponseEntity<>(assignQuizzesDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssignQuizDTO> getAssignQuizById(@PathVariable Long id) {
        AssignQuizDTO assignQuizDTO = serviceAssign.getById(id);
        return new ResponseEntity<>(assignQuizDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssignQuizDTO> updateAssignQuiz(@PathVariable Long id, @RequestBody AssignQuizDTO updatedAssignQuizDTO) {
        AssignQuizDTO updatedAssignQuiz = serviceAssign.updateAssign(id, updatedAssignQuizDTO);
        return new ResponseEntity<>(updatedAssignQuiz, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAssignQuiz(@PathVariable Long id) {
        serviceAssign.deleteAssign(id);
        return new ResponseEntity<>("Assignment deleted successfully", HttpStatus.OK);
    }

}
