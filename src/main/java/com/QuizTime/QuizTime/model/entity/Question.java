package com.QuizTime.QuizTime.model.entity;

import com.QuizTime.QuizTime.enums.TypeAnswer;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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


    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Validation> validationList;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    private Level level;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Media> medias;


    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionTemporation> questionTemporationList;

}
