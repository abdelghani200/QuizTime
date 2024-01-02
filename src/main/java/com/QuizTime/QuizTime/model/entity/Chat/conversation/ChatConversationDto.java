package com.QuizTime.QuizTime.model.entity.Chat.conversation;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatConversationDto {
    private Long id;
    private Long teacherId;
    private Long studentId;

}
