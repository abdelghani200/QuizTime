package com.QuizTime.QuizTime.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @NotNull(message = "La date de debut ne peut pas etre null")
    private LocalDateTime start_Date;
    @NotNull(message = "La date de fin ne peut pas etre null")
    private LocalDateTime end_Date;
    @NotBlank(message = "Le score de reussite ne peut pas etre vide")
    private String successScore;
    @NotNull(message = "La vue des reponses ne peut pas etre null")
    private Boolean viewAnswer;
    @NotNull(message = "Le nombre maximal ne peut pas etre null")
    private Integer maxAttempts;

    private String remarks;
    private String instructions;

    @ManyToOne()
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


    @OneToOne(mappedBy = "quiz")
    @JoinColumn(name = "assignQuiz_id")
    private AssignQuiz assignQuiz;


    @OneToMany(mappedBy = "quiz")
    private List<QuestionTemporation> temporationList;


}
