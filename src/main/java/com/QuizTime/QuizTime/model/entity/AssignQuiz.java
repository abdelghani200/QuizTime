package com.QuizTime.QuizTime.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "assign_quiz")
public class AssignQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private String raison;
    private Double score;
    private Integer attemptNumber;
    private Double scoreFinal;

    @ManyToOne
    private Quiz quiz;

    @ManyToOne
    private Student student;

}
