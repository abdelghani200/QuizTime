package com.QuizTime.QuizTime.service.serviceInterface;


import com.QuizTime.QuizTime.model.entity.dto.AnswerQuestionDTO;
import com.QuizTime.QuizTime.model.entity.dto.QuestionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface questionService {

    List<QuestionDTO> getAllQuestions(int page, int size);

    QuestionDTO saveQuestion(QuestionDTO questionDTO);

    QuestionDTO updateQuestion(QuestionDTO questionDTO, long id);

    void deleteQuestion(long id);

    AnswerQuestionDTO findByID(Long id);


}
