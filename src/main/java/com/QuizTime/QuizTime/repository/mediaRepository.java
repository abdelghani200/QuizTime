package com.QuizTime.QuizTime.repository;

import com.QuizTime.QuizTime.model.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface mediaRepository extends JpaRepository<Media, Integer> {
}
