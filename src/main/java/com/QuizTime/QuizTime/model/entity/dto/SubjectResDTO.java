package com.QuizTime.QuizTime.model.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SubjectResDTO {
    private Integer id;
    private String title;
    private SubjectResDTO parent;
    private List<SubjectDTO> children;
}
