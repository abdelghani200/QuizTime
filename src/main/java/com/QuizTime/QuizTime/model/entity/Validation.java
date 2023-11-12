package com.QuizTime.QuizTime.model.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "validation")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double points;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reponse_id")
    private Answer answer;

    @OneToMany(mappedBy = "validation",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reponse> reponseList;
}
