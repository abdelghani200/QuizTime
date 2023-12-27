package com.QuizTime.QuizTime.helpers;

import com.QuizTime.QuizTime.model.entity.dto.AnswerDTO;
import com.QuizTime.QuizTime.model.entity.dto.QuestionDTO;
import com.QuizTime.QuizTime.model.entity.dto.QuizDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TempoQuestionRes {

    private QuizDTO quiz;

    private QuestionDTO question;

}
