package com.QuizTime.QuizTime.model.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    private Long teacher_id;
    private TeacherDTO teacher;


}
