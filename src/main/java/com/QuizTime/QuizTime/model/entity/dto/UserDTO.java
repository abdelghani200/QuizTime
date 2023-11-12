package com.QuizTime.QuizTime.model.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public abstract class UserDTO {
    private long id;
    protected String firstName;
    protected String lastName;
    protected LocalDate dateOfBirth;
    protected String address;
}
