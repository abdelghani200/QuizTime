package com.QuizTime.QuizTime.model.entity;

import com.QuizTime.QuizTime.enums.TypeAnswer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

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
    private Time duration;
    private TypeAnswer type;
    private Double scorePoints;

}
