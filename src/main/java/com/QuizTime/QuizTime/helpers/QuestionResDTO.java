package com.QuizTime.QuizTime.helpers;

import com.QuizTime.QuizTime.enums.TypeAnswer;
import com.QuizTime.QuizTime.model.entity.dto.MediaDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class QuestionResDTO {

    private long id;
    private Integer answerNumber;
    private Integer answerCorrectNumber;
    private String text;
    private TypeAnswer type;
    private Double scorePoints;
    private Long level_id;
    private Integer subject_id;
    private List<MediaDTO> medias = new ArrayList<>();

}
