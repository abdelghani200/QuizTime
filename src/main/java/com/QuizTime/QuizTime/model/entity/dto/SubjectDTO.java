package com.QuizTime.QuizTime.model.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubjectDTO {
    private Integer id;
    private String  title;
    private SubjectResDTO parent_id;
}
