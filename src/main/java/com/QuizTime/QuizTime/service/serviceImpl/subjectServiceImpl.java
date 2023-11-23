package com.QuizTime.QuizTime.service.serviceImpl;


import com.QuizTime.QuizTime.helpers.SubjectResDTO;
import com.QuizTime.QuizTime.model.entity.Subject;

import com.QuizTime.QuizTime.model.entity.dto.SubjectDTO;
import com.QuizTime.QuizTime.repository.subjectRepository;
import com.QuizTime.QuizTime.service.serviceInterface.subjectService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class subjectServiceImpl implements subjectService {

    @Autowired
    private subjectRepository Repo_subject;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<SubjectResDTO> getAllSubjects() {
        List<Subject> subjects = Repo_subject.findAll();
        return subjects.stream()
                .map(subject -> modelMapper.map(subject, SubjectResDTO.class))
                .toList();
    }

    @Override
    public SubjectDTO createSubject(SubjectDTO subjectDTO) {
        Subject subject = modelMapper.map(subjectDTO, Subject.class);

        if (subjectDTO.getParent_id() != null) {
            Subject parentSubject = Repo_subject.findById(subjectDTO.getParent_id()).orElse(null);
            if (parentSubject != null) {
                subject.setParent(parentSubject);
            } else {
                return null;
            }
        }

        subject = Repo_subject.save(subject);
        return modelMapper.map(subject, SubjectDTO.class);

    }



    @Override
    public void deleteSubject(Integer id) {
        Repo_subject.deleteById(id);
    }

    @Override
    public SubjectDTO updateSubject(SubjectDTO subjectDTO, Integer id) {
        Optional<Subject> existingSubjectOptional = Repo_subject.findById(id);

        if (existingSubjectOptional.isPresent()) {
            Subject existingSubject = existingSubjectOptional.get();
            existingSubject.setTitle(subjectDTO.getTitle());

            if (subjectDTO.getParent_id() != null) {
                existingSubject.setParent(
                        modelMapper.map(subjectDTO.getParent_id(), Subject.class)
                );
            }

            Subject updatedSubject = Repo_subject.save(existingSubject);
            return modelMapper.map(updatedSubject, SubjectDTO.class);
        } else {
            return null;
        }
    }

}
