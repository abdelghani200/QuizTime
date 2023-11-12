package com.QuizTime.QuizTime.model.entity.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class StudentDTO extends UserDTO {

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDate registrationDate;

}
