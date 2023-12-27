package com.QuizTime.QuizTime.helpers;

import com.QuizTime.QuizTime.enums.TypeMedia;
import com.QuizTime.QuizTime.model.entity.dto.QuestionDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MediaResDTO {


    private Integer id;
    private String link;
    private TypeMedia type;
    private QuestionDTO question;

}
