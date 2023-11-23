package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.model.entity.dto.QuestionTempoDTO;
import org.springframework.stereotype.Service;

@Service
public interface questionTempo {

    QuestionTempoDTO saveTempoQuestion(QuestionTempoDTO questionTempoDTO);

    void delete(Long questionID, Long quizID);

    QuestionTempoDTO update(Long id, QuestionTempoDTO tempoQuizDto);

}
