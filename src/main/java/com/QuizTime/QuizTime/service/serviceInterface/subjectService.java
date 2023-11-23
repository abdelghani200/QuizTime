package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.helpers.SubjectResDTO;
import com.QuizTime.QuizTime.model.entity.dto.SubjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface subjectService {

    List<SubjectResDTO> getAllSubjects();

    SubjectDTO createSubject(SubjectDTO subjectDTO);

    void deleteSubject(Integer id);

    SubjectDTO updateSubject(SubjectDTO subjectDTO, Integer id);

}
