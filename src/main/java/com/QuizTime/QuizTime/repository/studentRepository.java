package com.QuizTime.QuizTime.repository;

import com.QuizTime.QuizTime.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<Student, Long> {
}
