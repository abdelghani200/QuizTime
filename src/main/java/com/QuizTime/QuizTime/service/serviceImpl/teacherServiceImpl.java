package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.model.entity.Level;
import com.QuizTime.QuizTime.model.entity.Teacher;
import com.QuizTime.QuizTime.model.entity.dto.LevelDTO;
import com.QuizTime.QuizTime.model.entity.dto.TeacherDTO;
import com.QuizTime.QuizTime.repository.teacherRepository;
import com.QuizTime.QuizTime.service.serviceInterface.serviceTeacher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class teacherServiceImpl implements serviceTeacher {

    @Autowired
    private teacherRepository RepoTeacher;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TeacherDTO saveTeachers(TeacherDTO teacherDTO) {
        Teacher teacher = modelMapper.map(teacherDTO, Teacher.class);
        Teacher savedTeacher = RepoTeacher.save(teacher);

        return modelMapper.map(savedTeacher, TeacherDTO.class);
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> teachers = RepoTeacher.findAll();
        return teachers.stream()
                .map(teacher -> modelMapper.map(teacher, TeacherDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTeacher(Long id) {
        RepoTeacher.deleteById(id);
    }
}
