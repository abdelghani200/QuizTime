package com.QuizTime.QuizTime.helpers;

import com.QuizTime.QuizTime.model.entity.dto.AnswerDTO;
import com.QuizTime.QuizTime.model.entity.dto.QuestionDTO;
import lombok.Data;

@Data
public class ValidationRes {
    private Long id;
    private QuestionDTO question;
    private AnswerDTO answer;
    private Double points;
}
