package com.QuizTime.QuizTime.model.entity;

import com.QuizTime.QuizTime.enums.TypeAnswer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Time;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer answerNumber;
    private Integer answerCorrectNumber;
    private String text;
    @Enumerated(EnumType.STRING)
    private TypeAnswer type;
    private Double scorePoints;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = true)
    private Quiz quiz;

    @OneToMany(mappedBy = "question")
    private List<Answer> answerList;

    @ManyToOne
    private Level level;
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private Media media;
    @OneToOne
    private Validation validation;

    @ManyToMany
    private List<AssignQuiz> assignedQuiz;


}
