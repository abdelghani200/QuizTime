package com.QuizTime.QuizTime.model.entity.Chat.conversation;

import com.QuizTime.QuizTime.model.entity.Teacher;
import com.QuizTime.QuizTime.model.entity.dto.StudentDTO;
import com.QuizTime.QuizTime.model.entity.dto.TeacherDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatConversationResDto {

    private Long id;
    private TeacherDTO teacher;
    private StudentDTO student;

}
