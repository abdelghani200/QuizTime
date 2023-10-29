package com.QuizTime.QuizTime.model.entity;

import com.QuizTime.QuizTime.enums.MediaType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Media {

    private Integer id;
    private String link;
    private MediaType type;
}
