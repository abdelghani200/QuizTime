package com.QuizTime.QuizTime.model.entity.dto;

import com.QuizTime.QuizTime.enums.TypeAnswer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    private List<MediaDTO> medias = new ArrayList<>();
}
