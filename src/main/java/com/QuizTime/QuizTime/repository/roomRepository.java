package com.QuizTime.QuizTime.repository;

import com.QuizTime.QuizTime.model.entity.Chat.salon.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface roomRepository extends JpaRepository<Room, Long> {
}
