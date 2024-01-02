package com.QuizTime.QuizTime.controller;

import com.QuizTime.QuizTime.model.entity.Chat.message.MessageDto;
import com.QuizTime.QuizTime.model.entity.Chat.message.MessageResDto;
import com.QuizTime.QuizTime.service.serviceInterface.chatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class controllerChat {

    private final chatService ServiceChat;
    @Autowired
    public controllerChat(chatService serviceChat) {
        ServiceChat = serviceChat;
    }

    @PostMapping("/chat/saveMessage")
    public MessageResDto saveMessage(@RequestBody MessageResDto messageResDto){
        return ServiceChat.saveMessage(messageResDto);
    }
    @GetMapping("/getMessage/{roomId}")
    public List<MessageDto> getMessage(@PathVariable Long roomId) {
        return ServiceChat.getMessagesByRoomId(roomId);
    }

    @GetMapping("/messages")
    public List<MessageDto> getMessages(){
        return ServiceChat.getMessages();
    }

}
