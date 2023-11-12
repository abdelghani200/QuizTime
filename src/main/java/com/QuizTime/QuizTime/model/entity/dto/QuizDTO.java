package com.QuizTime.QuizTime.model.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class QuizDTO {

    private long id;
    private String title;
    private LocalDateTime start_Date;
    private LocalDateTime end_Date;
    private String successScore;
    private Boolean viewAnswer;
    private Integer maxAttempts;
    private String remarks;
    private String instructions;

}
