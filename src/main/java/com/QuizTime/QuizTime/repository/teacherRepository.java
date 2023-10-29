package com.QuizTime.QuizTime.repository;

import com.QuizTime.QuizTime.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface teacherRepository extends JpaRepository<Teacher, Long> {
}
