package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.exception.ExceptionQuestion;
import com.QuizTime.QuizTime.model.entity.Question;
import com.QuizTime.QuizTime.model.entity.dto.QuestionDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface questionService {

    List<QuestionDTO> getAllQuestions();

    QuestionDTO saveQuestion(QuestionDTO questionDTO);

    QuestionDTO updateQuestion(QuestionDTO questionDTO, long id) throws ExceptionQuestion;

    void deleteQuestion(long id);

    Optional<Question> getOne(long id);


}
