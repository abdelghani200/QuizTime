package com.QuizTime.QuizTime.model.entity.Chat.message;

import com.QuizTime.QuizTime.enums.MessageType;
import com.QuizTime.QuizTime.model.entity.Chat.conversation.ChatConversationDto;
import com.QuizTime.QuizTime.model.entity.Chat.conversation.ChatConversationResDto;
import com.QuizTime.QuizTime.model.entity.Chat.salon.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class MessageDto {
    private String content;
    private String sender;
    private MessageType type;
    private Room room;
    private ChatConversationResDto conversation;
}
