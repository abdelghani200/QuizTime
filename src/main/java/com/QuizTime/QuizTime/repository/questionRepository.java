package com.QuizTime.QuizTime.repository;

import com.QuizTime.QuizTime.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface questionRepository extends JpaRepository<Question, Long> {
}
