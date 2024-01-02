package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.model.entity.Chat.conversation.ChatConversation;
import com.QuizTime.QuizTime.model.entity.Chat.conversation.ChatConversationDto;
import com.QuizTime.QuizTime.repository.conversationRepository;
import com.QuizTime.QuizTime.service.serviceInterface.conversationService;
import jakarta.ws.rs.NotFoundException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class conversationServiceImpl implements conversationService {

    private final conversationRepository RepoConversation;
    private final Logger logger = LoggerFactory.getLogger(chatServiceImpl.class);
    private final ModelMapper modelMapper;

    public conversationServiceImpl(conversationRepository repoConversation, ModelMapper modelMapper) {
        RepoConversation = repoConversation;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<ChatConversationDto> getAllConversations() {
        List<ChatConversation> conversations = RepoConversation.findAll();
        return conversations.stream()
                .map(conversation -> modelMapper.map(conversation, ChatConversationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ChatConversationDto getConversationById(Long id) {
        ChatConversation conversation = RepoConversation.findById(id)
                .orElseThrow(() -> new NotFoundException("Conversation not found with id: " + id));
        return modelMapper.map(conversation, ChatConversationDto.class);
    }

    @Override
    public ChatConversationDto createConversation(ChatConversationDto conversationDTO) {
        ChatConversation conversationToSave = modelMapper.map(conversationDTO, ChatConversation.class);
        ChatConversation savedConversation = RepoConversation.save(conversationToSave);
        return modelMapper.map(savedConversation, ChatConversationDto.class);
    }
}
