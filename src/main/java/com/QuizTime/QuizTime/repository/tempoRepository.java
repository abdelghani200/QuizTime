package com.QuizTime.QuizTime.repository;


import com.QuizTime.QuizTime.helpers.TemporationId;
import com.QuizTime.QuizTime.model.entity.QuestionTemporation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tempoRepository extends JpaRepository<QuestionTemporation, TemporationId> {

}
