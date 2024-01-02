package com.QuizTime.QuizTime.controller;

import com.QuizTime.QuizTime.model.entity.Chat.conversation.ChatConversationDto;
import com.QuizTime.QuizTime.service.serviceInterface.conversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conversations")
public class controllerConversation {

    private final conversationService ServiceConv;

    @Autowired
    public controllerConversation(conversationService conversationService) {
        this.ServiceConv = conversationService;
    }

    @GetMapping
    public ResponseEntity<List<ChatConversationDto>> getAllConversations() {
        List<ChatConversationDto> conversations = ServiceConv.getAllConversations();
        return ResponseEntity.ok(conversations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatConversationDto> getConversationById(@PathVariable Long id) {
        ChatConversationDto conversation = ServiceConv.getConversationById(id);
        return ResponseEntity.ok(conversation);
    }
    @PostMapping
    public ResponseEntity<ChatConversationDto> createConversation(@RequestBody ChatConversationDto conversationDTO) {
        ChatConversationDto createdConversation = ServiceConv.createConversation(conversationDTO);
        return new ResponseEntity<>(createdConversation, HttpStatus.CREATED);
    }


}
