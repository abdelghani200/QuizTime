package com.QuizTime.QuizTime.model.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubjectDTO {
    private Integer id;
    private String  title;
    private Integer parent_id;
}
