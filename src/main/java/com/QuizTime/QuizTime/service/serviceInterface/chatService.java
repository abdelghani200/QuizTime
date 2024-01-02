package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.model.entity.Chat.message.MessageDto;
import com.QuizTime.QuizTime.model.entity.Chat.message.MessageResDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface chatService {
    MessageResDto saveMessage(MessageResDto messageResDto);
    List<MessageDto> getMessagesByRoomId(Long roomId);
    List<MessageDto> getMessages();
}
