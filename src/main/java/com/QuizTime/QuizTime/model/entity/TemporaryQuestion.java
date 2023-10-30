package com.QuizTime.QuizTime.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "temporary_questions")
public class TemporaryQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @ManyToOne
    private Quiz quiz;
    @OneToOne
    private Question question;
    private int isTimed;
}
