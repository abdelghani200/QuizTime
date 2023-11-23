package com.QuizTime.QuizTime.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "assignQuiz")
public class AssignQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "La date de début ne peut pas etre null")
    private LocalDateTime date_debut;

    @NotNull(message = "La date de fin ne peut pas etre nul")
    private LocalDateTime date_fin;

    @Column
    private String raison;

    @Column
    @Min(value = 0, message = "score can't be negative")
    private Double score;

    @Min(value = 0, message = "attempt number can't be negative")
    private Integer attempt_number;

    @Min(value = 0, message = "score final can't be negative")
    private Double score_final;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "assignment",
            joinColumns = @JoinColumn(name = "assign_quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;


    @OneToMany(mappedBy = "assignQuiz",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reponse> reponseList;


}
