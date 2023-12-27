package com.QuizTime.QuizTime.service.serviceInterface;


import com.QuizTime.QuizTime.helpers.MediaResDTO;
import com.QuizTime.QuizTime.helpers.QuestionResDTO;
import com.QuizTime.QuizTime.model.entity.dto.AnswerQuestionDTO;
import com.QuizTime.QuizTime.model.entity.dto.MediaDTO;
import com.QuizTime.QuizTime.model.entity.dto.QuestionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface questionService {

    List<QuestionDTO> getAllQuestions(int page, int size);

    QuestionResDTO saveQuestion(QuestionResDTO questionDTO);

    QuestionResDTO updateQuestion(QuestionResDTO questionDTO, long id);

    void deleteQuestion(long id);

    AnswerQuestionDTO findByID(Long id);

    List<QuestionDTO> AllQuestions();

    List<MediaResDTO> getAllMedia();


}
