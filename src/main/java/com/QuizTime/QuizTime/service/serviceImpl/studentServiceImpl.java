package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.model.entity.Level;
import com.QuizTime.QuizTime.model.entity.Student;
import com.QuizTime.QuizTime.model.entity.dto.LevelDTO;
import com.QuizTime.QuizTime.model.entity.dto.StudentDTO;
import com.QuizTime.QuizTime.repository.studentRepository;
import com.QuizTime.QuizTime.service.serviceInterface.studentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class studentServiceImpl implements studentService {

    @Autowired
    private studentRepository studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getStudent() {
        List<Student> students = studentRepo.findAll();
        return students.stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }
}
