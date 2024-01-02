package com.QuizTime.QuizTime.repository;

import com.QuizTime.QuizTime.model.entity.Student;
import com.QuizTime.QuizTime.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface teacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByUsername(String username);
}
