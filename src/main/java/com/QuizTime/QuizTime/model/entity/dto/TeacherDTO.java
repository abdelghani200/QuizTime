package com.QuizTime.QuizTime.model.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeacherDTO extends UserDTO {
    private long id;
    private String speciality;
}
