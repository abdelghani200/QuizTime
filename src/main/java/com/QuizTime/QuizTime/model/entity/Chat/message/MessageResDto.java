package com.QuizTime.QuizTime.model.entity.Chat.message;

import com.QuizTime.QuizTime.enums.MessageType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageResDto {
    private String content;
    private String sender;
    private MessageType type;
    private Long room_id;
    private Long conversation_id;
}
