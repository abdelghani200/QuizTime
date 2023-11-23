package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.model.entity.dto.AssignQuizDTO;

import java.util.List;

public interface assignService {

    List<AssignQuizDTO> saveAssign(List<AssignQuizDTO> assignQuizDTO);

    List<AssignQuizDTO> getAll();

    void deleteAssign(Long id);

    AssignQuizDTO updateAssign(Long id, AssignQuizDTO updatedAssignQuizDTO);

    AssignQuizDTO getById(Long id);
}
