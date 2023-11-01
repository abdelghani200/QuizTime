package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.exception.ExceptionAnswer;
import com.QuizTime.QuizTime.model.entity.Answer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface answerService {

    List<Answer> getAllAnswers();

    Answer saveAnswer(Answer answer);

    void deleteAnswer(Long id);

    Answer updateAnswer(Answer answer, Long id) throws ExceptionAnswer;

}
