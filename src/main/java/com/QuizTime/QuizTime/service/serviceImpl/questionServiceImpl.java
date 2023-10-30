package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.model.entity.Question;
import com.QuizTime.QuizTime.repository.questionRepository;
import com.QuizTime.QuizTime.service.serviceInterface.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class questionServiceImpl implements questionService {

    @Autowired
    private questionRepository Repoquestion;

    @Override
    public Question saveQuestion(Question question) {
        return Repoquestion.save(question);
    }


    @Override
    public Question updateQuestion(Question question, int id) {
        return Repoquestion.save(question);
    }


}
