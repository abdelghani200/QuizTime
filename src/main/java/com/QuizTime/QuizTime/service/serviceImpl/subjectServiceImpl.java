package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.exception.ExceptionLevel;
import com.QuizTime.QuizTime.exception.ExceptionSubject;
import com.QuizTime.QuizTime.model.entity.Level;
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

    @Override
    public Subject saveSubject(Subject subject) {
        return Repo_subject.save(subject);
    }

    @Override
    public void deleteSubject(Integer id) {
        Repo_subject.deleteById(id);
    }

    @Override
    public Subject updateSubject(Subject subject, Integer id) throws ExceptionSubject {
        return Repo_subject.findById(id)
                .map(existingSubject -> {
                    existingSubject.setTitle(subject.getTitle());
                    existingSubject.setChildren(subject.getChildren());

                    return Repo_subject.save(existingSubject);
                })
                .orElseThrow(() -> new ExceptionSubject("Subject not found with ID: " + id));
    }
}
