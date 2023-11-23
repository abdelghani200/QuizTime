package com.QuizTime.QuizTime.model.entity;

import com.QuizTime.QuizTime.enums.TypeMedia;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "media")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Le lien du media ne peut pas etre vide")
    private String link;
    @NotNull(message = "Le type du media ne peut pas etre nul")
    @Enumerated(EnumType.STRING)
    private TypeMedia type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;


}
