package com.QuizTime.QuizTime.model.entity.dto;

import java.time.LocalDateTime;

public class AssignQuizDTO {
    private long id;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private String raison;
    private Double score;
    private Integer attemptNumber;
    private Double scoreFinal;
    private StudentDTO student;
    private QuizDTO quiz;
}
