package com.QuizTime.QuizTime;

import com.QuizTime.QuizTime.exception.ExceptionAnswer;
import com.QuizTime.QuizTime.model.entity.Answer;
import com.QuizTime.QuizTime.repository.answerRepository;
import com.QuizTime.QuizTime.service.serviceImpl.answerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
    void testGetAllAnswers() {
        when(RepoAnswer.findAll()).thenReturn(List.of(new Answer(), new Answer()));

        var result = answerService.getAllAnswers();

        assertEquals(2, result.size());
    }
    @Test
    void testSaveAnswer() {
        Answer answerToSave = new Answer();

        when(RepoAnswer.save(answerToSave)).thenReturn(answerToSave);

        Answer savedAnswer = answerService.saveAnswer(answerToSave);

        assertNotNull(savedAnswer);
        assertEquals(answerToSave, savedAnswer);

    }

    @Test
    void testUpdateAnswer() throws ExceptionAnswer {
        long id = 1;

        Answer existingAnswer = new Answer();
        Answer updatedAnswer = new Answer();

        updatedAnswer.setAnswerText("Updated AnswerText");

        when(RepoAnswer.findById(id)).thenReturn(Optional.of(existingAnswer));
        when(RepoAnswer.save(existingAnswer)).thenReturn(updatedAnswer);

        Answer result = answerService.updateAnswer(updatedAnswer, id);

        assertNotNull(result);
        assertEquals(updatedAnswer.getAnswerText(), result.getAnswerText());

    }

    @Test
    void testDeleteAnswer() {
        long id = 1;
        answerService.deleteAnswer(id);

        verify(RepoAnswer, times(1)).deleteById(id);
    }

}
