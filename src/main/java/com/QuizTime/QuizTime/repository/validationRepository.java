package com.QuizTime.QuizTime.repository;

import com.QuizTime.QuizTime.model.entity.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface validationRepository extends JpaRepository<Validation, Long> {

}
