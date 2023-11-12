package com.QuizTime.QuizTime.model.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnswerDTO {

    private long id;
    private String answerText;
    private Double point;

}
