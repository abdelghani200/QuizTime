package com.QuizTime.QuizTime.repository;

import com.QuizTime.QuizTime.model.entity.Chat.conversation.ChatConversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface conversationRepository extends JpaRepository<ChatConversation, Long> {
}
