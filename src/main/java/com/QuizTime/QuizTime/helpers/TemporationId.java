package com.QuizTime.QuizTime.helpers;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class TemporationId {

    @NotNull
    @Column(name = "quiz_id")
    private Long quiz;

    @NotNull
    @Column(name = "question_id")
    private Long question;

}
