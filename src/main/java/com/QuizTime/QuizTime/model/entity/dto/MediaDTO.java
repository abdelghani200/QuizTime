package com.QuizTime.QuizTime.model.entity.dto;

import com.QuizTime.QuizTime.enums.TypeMedia;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MediaDTO {

    private Integer id;
    private String link;
    private TypeMedia type;
    @JsonIgnore
    private QuestionDTO questionDTO;
}
