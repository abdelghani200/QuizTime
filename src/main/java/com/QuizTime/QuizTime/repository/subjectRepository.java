package com.QuizTime.QuizTime.repository;

import com.QuizTime.QuizTime.model.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface subjectRepository extends JpaRepository<Subject, Integer> {
}
