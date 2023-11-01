package com.QuizTime.QuizTime.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private LocalDateTime start_Date;
    private LocalDateTime end_Date;
    private String successScore;
    private Boolean viewAnswer;
    private Integer maxAttempts;
    private String remarks;
    private String instructions;

    @ManyToOne
    private Teacher teacher;

    @OneToMany(mappedBy = "quiz")
    private List<Question> questionList;

    @ManyToOne
    private Student student;

}
