package com.QuizTime.QuizTime.model.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnswerQuestionDTO {

    private Long id;
    private QuestionDTO question;
    private AnswerDTO answer;
    private Double points;

}
