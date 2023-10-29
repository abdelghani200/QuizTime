package com.QuizTime.QuizTime.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

@MappedSuperclass
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    protected String firstName;
    protected String lastName;
    protected LocalDate dateOfBirth;
    protected String address;

}
