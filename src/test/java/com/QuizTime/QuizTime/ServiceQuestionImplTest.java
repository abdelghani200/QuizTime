package com.QuizTime.QuizTime;

import com.QuizTime.QuizTime.enums.TypeAnswer;
import com.QuizTime.QuizTime.exception.ExceptionQuestion;
import com.QuizTime.QuizTime.helpers.QuestionResDTO;
import com.QuizTime.QuizTime.model.entity.Question;
import com.QuizTime.QuizTime.model.entity.dto.QuestionDTO;
import com.QuizTime.QuizTime.repository.questionRepository;
import com.QuizTime.QuizTime.service.serviceImpl.questionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceQuestionImplTest {

    @Mock
    private questionRepository Repoquestion;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private questionServiceImpl questionService;

    private Question question;
    private QuestionDTO questionDTO;

    private QuestionResDTO questionResDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        question = new Question();
        question.setId(1L);
        question.setText("text question");
        question.setType(TypeAnswer.single);
        question.setScorePoints(100.00);

        questionDTO = new QuestionDTO();
        questionDTO.setId(1L);
        questionDTO.setText("question tdo text");
        questionDTO.setType(TypeAnswer.single);
        questionDTO.setScorePoints(100.00);

        given(modelMapper.map(questionDTO, Question.class)).willReturn(question);
        given(modelMapper.map(question, QuestionDTO.class)).willReturn(questionDTO);
        given(Repoquestion.save(any(Question.class))).willReturn(question);
    }

    @Test
    void testGetAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        when(Repoquestion.findAll()).thenReturn(questionList);

        List<QuestionDTO> result = questionService.getAllQuestions(0,10);

        verify(Repoquestion, times(1)).findAll();

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    /*
    @Test
    void testSaveQuestion() {
        QuestionDTO savedQuestion = questionService.saveQuestion(questionDTO);

        // Then
        assertThat(savedQuestion).isNotNull();

        // Verify that save method is called exactly once with the expected Question object
        verify(Repoquestion).save(question);
    }

     */

    @Test
    void testDeleteQuestion() {
        long id = 1;

        questionService.deleteQuestion(id);

        verify(Repoquestion, times(1)).deleteById(id);
    }

    @Test
    void testUpdateQuestion() {
        long id = 1;

        Optional<Question> optionalQuestion = Optional.of(question);

        when(Repoquestion.findById(id)).thenReturn(optionalQuestion);

        assertThrows(ExceptionQuestion.class, () -> questionService.updateQuestion(questionResDTO, id));

        verify(Repoquestion, times(1)).findById(id);
        verify(Repoquestion, times(0)).save(any(Question.class));
    }



}
