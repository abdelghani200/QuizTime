package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.model.entity.Chat.conversation.ChatConversationDto;

import java.util.List;

public interface conversationService {

    public List<ChatConversationDto> getAllConversations();
    ChatConversationDto getConversationById(Long id);
    ChatConversationDto createConversation(ChatConversationDto conversationDTO);
}
