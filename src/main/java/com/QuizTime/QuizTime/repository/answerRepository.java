package com.QuizTime.QuizTime.repository;

import com.QuizTime.QuizTime.model.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface answerRepository extends JpaRepository<Answer, Long> {
}
