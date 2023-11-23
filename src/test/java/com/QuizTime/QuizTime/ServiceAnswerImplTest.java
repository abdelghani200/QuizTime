package com.QuizTime.QuizTime;

import com.QuizTime.QuizTime.exception.ExceptionAnswer;
import com.QuizTime.QuizTime.model.entity.Answer;
import com.QuizTime.QuizTime.model.entity.dto.AnswerDTO;
import com.QuizTime.QuizTime.repository.answerRepository;
import com.QuizTime.QuizTime.service.serviceImpl.answerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceAnswerImplTest {

    @Mock
    private answerRepository RepoAnswer;

    @InjectMocks
    private answerServiceImpl answerService;


    @Test
    void testDeleteAnswer() {
        long id = 1;
        answerService.deleteAnswer(id);

        verify(RepoAnswer, times(1)).deleteById(id);
    }

}
