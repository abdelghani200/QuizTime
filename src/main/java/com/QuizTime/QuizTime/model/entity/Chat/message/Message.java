package com.QuizTime.QuizTime.model.entity.Chat.message;

import com.QuizTime.QuizTime.enums.MessageType;
import com.QuizTime.QuizTime.model.entity.Chat.conversation.ChatConversation;
import com.QuizTime.QuizTime.model.entity.Chat.salon.Room;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private String sender;
    @Enumerated(EnumType.STRING)
    private MessageType type;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private ChatConversation conversation;
}
