package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.helpers.TempoQuestionRes;
import com.QuizTime.QuizTime.helpers.TemporationId;
import com.QuizTime.QuizTime.helpers.ValidationRes;
import com.QuizTime.QuizTime.model.entity.dto.QuestionTempoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface questionTempo {

    QuestionTempoDTO saveTempoQuestion(QuestionTempoDTO questionTempoDTO);
    void delete(Long questionID, Long quizID);
    QuestionTempoDTO update(Long id, QuestionTempoDTO tempoQuizDto);
    List<TempoQuestionRes> getAllTempoQuestions();
    List<TempoQuestionRes> getTempoQuestionsForQuiz(Long quizID);

}
