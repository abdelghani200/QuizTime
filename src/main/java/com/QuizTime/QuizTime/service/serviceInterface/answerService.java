package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.exception.ExceptionAnswer;
import com.QuizTime.QuizTime.model.entity.Answer;
import com.QuizTime.QuizTime.model.entity.dto.AnswerDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface answerService {

    List<AnswerDTO> getAllAnswers();

    AnswerDTO saveAnswer(AnswerDTO answerDTO);

    void deleteAnswer(Long id);

    AnswerDTO updateAnswer(AnswerDTO answerDTO, long id);

    AnswerDTO findByID(Long id);

}
