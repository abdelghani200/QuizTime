package com.QuizTime.QuizTime.model.entity.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionTempoDTO {

    private Long question_id;
    private Long quiz_id;
    private Integer time;

}
