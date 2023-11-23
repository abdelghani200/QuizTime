package com.QuizTime.QuizTime.model.entity;

import com.QuizTime.QuizTime.enums.TypeAnswer;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Le numero de reponse ne peut pas etre null")
    private Integer answerNumber;
    @NotNull(message = "Le numero de reponse correcte ne peut pas etre null")
    private Integer answerCorrectNumber;
    @NotBlank(message = "le texte de la question ne peut pas etre vide")
    private String text;
    @NotNull(message = "le type de reponse ne peut pas etre nul")
    @Enumerated(EnumType.STRING)
    private TypeAnswer type;
    @NotNull(message = "les points ne peuvent pas etre null")
    @DecimalMin(value = "0.0", message = "Les points doivent etre egaux ou superieurs a 0")
    private Double scorePoints;

    @Valid
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Validation> validationList;

    @NotNull(message = "le niveau ne peut pas etre null")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    private Level level;

    @NotNull(message = "Le sujet ne peut pas être nul")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Valid
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Media> medias;

    @Valid
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionTemporation> questionTemporationList;

}
