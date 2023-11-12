package com.QuizTime.QuizTime.model.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LevelDTO {

    private long id;
    private String description;
    private Double maxPoints;
    private Double minPoints;


}
