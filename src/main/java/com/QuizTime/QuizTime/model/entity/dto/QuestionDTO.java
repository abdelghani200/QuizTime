package com.QuizTime.QuizTime.model.entity.dto;

import com.QuizTime.QuizTime.enums.TypeAnswer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionDTO {
    private long id;
    private Integer answerNumber;
    private Integer answerCorrectNumber;
    private String text;
    private TypeAnswer type;
    private Double scorePoints;
    private LevelDTO level;
    private SubjectDTO subject;
}
