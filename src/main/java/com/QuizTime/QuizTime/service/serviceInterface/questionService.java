package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.model.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface questionService {

    List<Question> getAll();

    Question saveQuestion(Question question);

    Question updateQuestion(Question question, int id);

    void deleteQuestion(long id);

    Optional<Question> getOne(long id);

}
