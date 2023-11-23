package com.QuizTime.QuizTime.model.entity;

import com.QuizTime.QuizTime.helpers.TemporationId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "QuestionTempo")
public class QuestionTemporation {

    @EmbeddedId
    private TemporationId id ;
    @Column
    private int time;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("quiz_id")
    private Quiz quiz;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("question_id")
    private Question question;

}
