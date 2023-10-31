package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.model.entity.Subject;
import com.QuizTime.QuizTime.repository.subjectRepository;
import com.QuizTime.QuizTime.service.serviceInterface.subjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class subjectServiceImpl implements subjectService {

    @Autowired
    private subjectRepository Repo_subject;

    @Override
    public List<Subject> getAllSubjects() {
        return Repo_subject.findAll();
    }


}
