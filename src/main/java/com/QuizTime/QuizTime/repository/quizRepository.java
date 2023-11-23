package com.QuizTime.QuizTime.repository;

import com.QuizTime.QuizTime.model.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface quizRepository extends JpaRepository<Quiz, Long> {

}
