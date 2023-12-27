package com.QuizTime.QuizTime.repository;


import com.QuizTime.QuizTime.helpers.TemporationId;
import com.QuizTime.QuizTime.model.entity.QuestionTemporation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface tempoRepository extends JpaRepository<QuestionTemporation, TemporationId> {

    List<QuestionTemporation> findAllById_Quiz(Long quizId);

}
