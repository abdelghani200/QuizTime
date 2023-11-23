package com.QuizTime.QuizTime.helpers;

import com.QuizTime.QuizTime.model.entity.dto.SubjectDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor

public class SubjectResDTO {
    private Long id;
    @NotBlank(message = "title of the subject is required")
    private String title;
    private SubjectDTO parent;
    private List<SubjectDTO> children;
}
