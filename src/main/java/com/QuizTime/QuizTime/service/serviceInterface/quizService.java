package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.model.entity.dto.AnswerQuestionDTO;
import com.QuizTime.QuizTime.model.entity.dto.LevelDTO;
import com.QuizTime.QuizTime.model.entity.dto.QuizDTO;

import java.util.List;

public interface quizService {

    QuizDTO saveQuiz(QuizDTO quizDTO);

    QuizDTO findByID(Long id);

    List<QuizDTO> getAllQuiz(int page, int size);

    QuizDTO updateQuiz(QuizDTO quizDTO, Long id);

    QuizDTO deleteQuiz(Long id);



}
