package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.exception.CustomException;
import com.QuizTime.QuizTime.model.entity.Answer;
import com.QuizTime.QuizTime.model.entity.AssignQuiz;
import com.QuizTime.QuizTime.model.entity.Quiz;
import com.QuizTime.QuizTime.model.entity.Student;
import com.QuizTime.QuizTime.model.entity.dto.AnswerDTO;
import com.QuizTime.QuizTime.model.entity.dto.AssignQuizDTO;
import com.QuizTime.QuizTime.model.entity.dto.QuizDTO;
import java.util.Objects;

import com.QuizTime.QuizTime.model.entity.dto.StudentDTO;
import com.QuizTime.QuizTime.repository.assignRepository;
import com.QuizTime.QuizTime.repository.quizRepository;
import com.QuizTime.QuizTime.repository.studentRepository;
import com.QuizTime.QuizTime.service.serviceInterface.assignService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class assignServiceImpl implements assignService {
    @Autowired
    private assignRepository RepoAssign;

    @Autowired
    private studentRepository RepoStudent;

    @Autowired
    private quizRepository RepoQuiz;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public List<AssignQuizDTO> saveAssign(List<AssignQuizDTO> assignQuizDTOList) {
        return assignQuizDTOList.stream()
                .map(assignQuizDTO -> {
                    AssignQuiz assignQuiz = modelMapper.map(assignQuizDTO, AssignQuiz.class);

                    if (assignQuizDTO.getStudents() != null && !assignQuizDTO.getStudents().isEmpty()) {
                        List<Student> students = new ArrayList<>();

                        for (StudentDTO studentDTO : assignQuizDTO.getStudents()) {
                            Student student = RepoStudent.findById(studentDTO.getId())
                                    .orElseThrow(() -> new CustomException("The student with id " + studentDTO.getId() + " is not found"));
                            students.add(student);
                        }

                        assignQuiz.setStudents(students);
                    }

                    return modelMapper.map(RepoAssign.save(assignQuiz), AssignQuizDTO.class);
                })
                .collect(Collectors.toList());
    }




    @Override
    public List<AssignQuizDTO> getAll() {
        List<AssignQuiz> assignAll = RepoAssign.findAll();
        return assignAll.stream()
                .map(assign -> modelMapper.map(assign, AssignQuizDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AssignQuizDTO getById(Long id) {
        AssignQuiz assignQuiz = RepoAssign.findById(id)
                .orElseThrow(() -> new CustomException("The assignment with id " + id + " is not found"));
        return modelMapper.map(assignQuiz, AssignQuizDTO.class);
    }

    @Transactional
    @Override
    public AssignQuizDTO updateAssign(Long id, AssignQuizDTO updatedAssignQuizDTO) {
        AssignQuiz existingAssignQuiz = RepoAssign.findById(id)
                .orElseThrow(() -> new CustomException("The assignment with id " + id + " is not found"));

        // Update fields from updatedAssignQuizDTO
        // For example:
        existingAssignQuiz.setDate_debut(updatedAssignQuizDTO.getDate_debut());
        existingAssignQuiz.setDate_fin(updatedAssignQuizDTO.getDate_fin());
        existingAssignQuiz.setRaison(updatedAssignQuizDTO.getRaison());

        // Similarly, update other fields...

        // Save the updated assignment
        AssignQuiz updatedAssignQuiz = RepoAssign.save(existingAssignQuiz);
        return modelMapper.map(updatedAssignQuiz, AssignQuizDTO.class);
    }


    @Override
    public void deleteAssign(Long id) {
        // Check if the assignment exists
        Optional<AssignQuiz> assignQuizOptional = RepoAssign.findById(id);
        if (assignQuizOptional.isPresent()) {
            RepoAssign.deleteById(id);
        } else {
            throw new CustomException("The assignment with id " + id + " is not found");
        }
    }


}
