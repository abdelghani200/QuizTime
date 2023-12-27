package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.exception.CustomException;
import com.QuizTime.QuizTime.model.entity.Question;
import com.QuizTime.QuizTime.model.entity.Quiz;
import com.QuizTime.QuizTime.model.entity.Teacher;
import com.QuizTime.QuizTime.model.entity.dto.QuizDTO;
import com.QuizTime.QuizTime.repository.questionRepository;
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
import java.util.stream.Collectors;

@Service
public class quizServiceImpl implements quizService {

    @Autowired
    private quizRepository RepoQuiz;

    @Autowired
    private teacherRepository RepoTeacher;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private questionRepository Repoquestion;

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

    /*
    @Transactional
    @Override
    public QuizDTO addQuestionsToQuiz(Long quizId, List<Long> questionIds) {
        // Récupérer le quiz existant
        Quiz quiz = RepoQuiz.findById(quizId)
                .orElseThrow(() -> new CustomException("The quiz with ID " + quizId + " is not found"));

        // Récupérer les questions à ajouter au quiz
        List<Question> questionsToAdd = questionIds.stream()
                .map(questionId -> Repoquestion.findById(questionId)
                        .orElseThrow(() -> new CustomException("Question not found with ID: " + questionId)))
                .collect(Collectors.toList());

        // Ajouter les questions au quiz
        quiz.getQuestions().addAll(questionsToAdd);

        // Mettre à jour le quiz dans la base de données
        Quiz updatedQuiz = RepoQuiz.save(quiz);

        // Mapper et retourner le résultat
        return modelMapper.map(updatedQuiz, QuizDTO.class);
    }

     */



}
