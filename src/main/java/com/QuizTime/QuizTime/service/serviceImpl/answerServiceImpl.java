package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.exception.ExceptionAnswer;
import com.QuizTime.QuizTime.exception.ExceptionLevel;
import com.QuizTime.QuizTime.model.entity.Answer;
import com.QuizTime.QuizTime.repository.answerRepository;
import com.QuizTime.QuizTime.service.serviceInterface.answerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class answerServiceImpl implements answerService {

    @Autowired
    private answerRepository RepoAnswer;
    @Override
    public List<Answer> getAllAnswers() {
        return RepoAnswer.findAll();
    }

    @Override
    public Answer saveAnswer(Answer answer) {
        return RepoAnswer.save(answer);
    }

    @Override
    public void deleteAnswer(Long id) {
        RepoAnswer.deleteById(id);
    }

    @Override
    public Answer updateAnswer(Answer answer, Long id) throws ExceptionAnswer {
        return RepoAnswer.findById(id)
                .map(existingAnswer -> {
                    existingAnswer.setAnswerText(answer.getAnswerText());
                    return RepoAnswer.save(existingAnswer);
                })
                .orElseThrow(() -> new ExceptionAnswer("Answer not found with ID: " + id));
    }
}
