package com.QuizTime.QuizTime.controller;

import com.QuizTime.QuizTime.model.entity.dto.TeacherDTO;
import com.QuizTime.QuizTime.service.serviceInterface.serviceTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teachers")
@CrossOrigin
public class controllerTeacher {

    @Autowired
    private serviceTeacher serviceTeacher;

    @GetMapping
    public List<TeacherDTO> getTeachers(){
        return serviceTeacher.getAllTeachers();
    }

    @PostMapping
    public TeacherDTO saveTeacher(@RequestBody TeacherDTO teacherDTO) {
        return serviceTeacher.saveTeachers(teacherDTO);
    }

    @DeleteMapping("/{teacherId}")
    public void deleteTeacher(@PathVariable("teacherId") Long id){
        serviceTeacher.deleteTeacher(id);
    }


}
