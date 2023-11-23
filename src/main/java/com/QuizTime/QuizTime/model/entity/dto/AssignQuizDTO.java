package com.QuizTime.QuizTime.model.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor

public class AssignQuizDTO {
    private long id;
    private LocalDateTime date_debut;
    private LocalDateTime date_fin;
    private String raison;
    private Double score;
    private Integer attempt_number;
    private Double score_final;
    private List<StudentDTO> students;
    private QuizDTO quiz;
}
