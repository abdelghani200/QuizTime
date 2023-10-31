package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.model.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface subjectService {

    List<Subject> getAllSubjects();

    Subject saveSubject(Subject subject);

    void deleteSubject(Integer id);

}
