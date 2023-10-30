package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.model.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface questionService {



    Question saveQuestion(Question question);

    Question updateQuestion(Question question, int id);

}
