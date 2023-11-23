package com.QuizTime.QuizTime.model.entity.dto;

import lombok.Data;

@Data
public class ValidationDTO {

    private Long id;
    private Long question_id;
    private Long response_id;
    private Double points;

}
