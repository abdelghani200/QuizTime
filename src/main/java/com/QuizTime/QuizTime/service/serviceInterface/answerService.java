package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.model.entity.Answer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface answerService {

    List<Answer> getAllAnswers();

}
