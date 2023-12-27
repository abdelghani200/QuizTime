package com.QuizTime.QuizTime.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "teachers")
public class Teacher extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String speciality;


    @OneToMany(mappedBy = "teacher",fetch = FetchType.LAZY)
    private List<Quiz> quizList;
}
