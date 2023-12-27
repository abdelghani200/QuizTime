package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.exception.ExceptionAnswer;
import com.QuizTime.QuizTime.exception.ExceptionQuestion;
import com.QuizTime.QuizTime.helpers.ValidationRes;
import com.QuizTime.QuizTime.model.entity.Answer;
import com.QuizTime.QuizTime.model.entity.Question;
import com.QuizTime.QuizTime.model.entity.dto.AnswerQuestionDTO;
import com.QuizTime.QuizTime.model.entity.dto.ValidationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface validationService {
    ValidationDTO save(ValidationDTO validationDto);

    List<ValidationRes> getValidations();

}
