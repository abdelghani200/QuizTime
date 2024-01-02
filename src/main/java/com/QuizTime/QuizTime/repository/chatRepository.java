package com.QuizTime.QuizTime.repository;

import com.QuizTime.QuizTime.model.entity.Chat.message.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface chatRepository extends JpaRepository<Message, Integer> {
    @Query("SELECT m FROM Message m WHERE m.room.id = :roomId")
    List<Message> findMessagesByRoomId(@Param("roomId") Long roomId);

}
