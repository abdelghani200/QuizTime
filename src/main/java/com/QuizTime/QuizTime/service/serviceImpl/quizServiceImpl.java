package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.exception.CustomException;
import com.QuizTime.QuizTime.model.entity.Quiz;
import com.QuizTime.QuizTime.model.entity.Teacher;
import com.QuizTime.QuizTime.model.entity.dto.QuizDTO;
import com.QuizTime.QuizTime.repository.quizRepository;
import com.QuizTime.QuizTime.repository.teacherRepository;
import com.QuizTime.QuizTime.service.serviceInterface.quizService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class quizServiceImpl implements quizService {

    @Autowired
    private quizRepository RepoQuiz;

    @Autowired
    private teacherRepository RepoTeacher;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuizDTO saveQuiz(QuizDTO quizDTO) {

        Quiz quiz = modelMapper.map(quizDTO, Quiz.class);
        if (quizDTO.getTeacher_id() != null) {
            Teacher teacher = RepoTeacher.findById(quizDTO.getTeacher_id())
                    .orElseThrow(() -> new CustomException("The trainer with id " + quizDTO.getTeacher_id() + " is not found"));
            quiz.setTeacher(teacher);
        }
        quiz = RepoQuiz.save(quiz);

        return modelMapper.map(quiz, QuizDTO.class);
    }

    @Override
    public QuizDTO findByID(Long id) {
        Quiz quiz = RepoQuiz.findById(id)
                .orElseThrow(() -> new CustomException("The quiz with id " + id + " is not found"));
        return modelMapper.map(quiz, QuizDTO.class);
    }


    @Override
    public List<QuizDTO> getAllQuiz(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Quiz> quizList = RepoQuiz.findAll(pageable);

        return quizList.getContent().stream()
                .map(quiz -> modelMapper.map(quiz, QuizDTO.class))
                .toList();
    }

    @Override
    public QuizDTO updateQuiz(QuizDTO quizDTO, Long id) {
        Optional<Quiz> existingQuiz = RepoQuiz.findById(id);
        if (existingQuiz.isEmpty()) {
            throw new CustomException("Quiz not found with ID: " + id);
        }

        Quiz quiz = existingQuiz.get();
        modelMapper.map(quizDTO, quiz);
        Quiz updatedQuiz = RepoQuiz.save(quiz);

        return modelMapper.map(updatedQuiz, QuizDTO.class);
    }

    @Transactional
    @Override
    public QuizDTO deleteQuiz(Long id) {
        Optional<Quiz> optionalQuiz = RepoQuiz.findById(id);
        if (optionalQuiz.isEmpty()) {
            throw new CustomException("Quiz not found with ID: " + id);
        }

        Quiz quiz = optionalQuiz.get();
        RepoQuiz.delete(quiz);

        return modelMapper.map(quiz, QuizDTO.class);
    }


}
