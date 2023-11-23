package com.QuizTime.QuizTime.model.entity;


import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "levels")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "La description du niveau ne peut pas etre vide")
    private String description;
    @NotNull(message = "La valeur maximale des points ne peut pas etre null")
    private Double maxPoints;
    @NotNull(message = "La valeur minimale des points ne peut pas être null")
    private Double minPoints;

    @OneToMany(mappedBy = "level", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;



}
