package com.QuizTime.QuizTime.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reponces")
public class Reponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer played;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assign_id")
    private AssignQuiz assignQuiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "validation_id")
    private Validation validation;

}
