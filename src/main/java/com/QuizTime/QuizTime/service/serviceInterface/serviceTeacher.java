package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.model.entity.dto.TeacherDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface serviceTeacher {
    TeacherDTO saveTeachers(TeacherDTO teacherDTO);
    List<TeacherDTO> getAllTeachers();
}
