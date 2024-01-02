package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.exception.CustomException;
import com.QuizTime.QuizTime.model.entity.Chat.conversation.ChatConversation;
import com.QuizTime.QuizTime.model.entity.Chat.message.Message;
import com.QuizTime.QuizTime.model.entity.Chat.message.MessageDto;
import com.QuizTime.QuizTime.model.entity.Chat.message.MessageResDto;
import com.QuizTime.QuizTime.model.entity.Chat.salon.Room;
import com.QuizTime.QuizTime.repository.chatRepository;
import com.QuizTime.QuizTime.repository.conversationRepository;
import com.QuizTime.QuizTime.repository.roomRepository;
import com.QuizTime.QuizTime.service.serviceInterface.chatService;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import org.slf4j.Logger;
import java.util.stream.Collectors;

@Service
public class chatServiceImpl implements chatService {

    private final chatRepository RepoChat;
    private final roomRepository RepoRoom;
    private final conversationRepository RepoConv;
    private final Logger logger = LoggerFactory.getLogger(chatServiceImpl.class);
    private final ModelMapper modelMapper;

    @Autowired
    public chatServiceImpl(chatRepository repoChat, roomRepository repoRoom,ModelMapper modelMapper, conversationRepository repoConv){
        RepoChat = repoChat;
        RepoRoom = repoRoom;
        RepoConv = repoConv;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public MessageResDto saveMessage(MessageResDto messageDto) {
        try {
            Message message = modelMapper.map(messageDto, Message.class);
            if (messageDto.getRoom_id() != null) {
                Room room = RepoRoom.findById(messageDto.getRoom_id())
                        .orElseThrow(() -> new CustomException("The room with id " + messageDto.getRoom_id() + " is not found"));
                message.setRoom(room);
            }
            if (messageDto.getConversation_id() != null) {
                ChatConversation conversation = RepoConv.findById(messageDto.getConversation_id())
                        .orElseThrow(() -> new CustomException("The conversation with id " + messageDto.getConversation_id() + " is not found"));
                message.setConversation(conversation);
            }
            message = RepoChat.save(message);


            return modelMapper.map(message, MessageResDto.class);
        } catch (Exception e) {
            logger.error("Error saving message: {}", e.getMessage());
            throw e;
        }
    }
    @Override
    public List<MessageDto> getMessagesByRoomId(Long roomId) {
        logger.info("Fetching messages for roomId: {}", roomId);

        List<Message> messages = RepoChat.findMessagesByRoomId(roomId);

        List<MessageDto> messageDtos = messages.stream()
                .map(message -> modelMapper.map(message, MessageDto.class))
                .collect(Collectors.toList());

        logger.info("Fetched messages: {}", messageDtos);

        return messageDtos;
    }


    @Override
    public List<MessageDto> getMessages() {
        List<Message> messages = RepoChat.findAll();
        logger.info("Fetched messages: {}", messages);

        return messages.stream()
                .map(message -> modelMapper.map(message, MessageDto.class))
                .collect(Collectors.toList());

    }
}
