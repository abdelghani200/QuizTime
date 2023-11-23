package com.QuizTime.QuizTime.repository;

import com.QuizTime.QuizTime.model.entity.AssignQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface assignRepository extends JpaRepository<AssignQuiz, Long> {
}
