package com.QuizTime.QuizTime;

import com.QuizTime.QuizTime.config.ModelMapperConfig;
import com.QuizTime.QuizTime.enums.TypeAnswer;
import com.QuizTime.QuizTime.exception.ExceptionQuestion;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceQuestionImplTest {

    @Mock
    private questionRepository Repoquestion;

    @Mock
    private ModelMapperConfig mapperConfig;

    @InjectMocks
    private questionServiceImpl questionService;

    private Question question;
    private QuestionDTO questionDTO;

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
    }

    @Test
    void testGetAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        when(Repoquestion.findAll()).thenReturn(questionList);

        List<QuestionDTO> result = questionService.getAllQuestions();

        verify(Repoquestion, times(1)).findAll();

        assertNotNull(result);
        assertEquals(0, result.size());
    }

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

        assertThrows(ExceptionQuestion.class, () -> questionService.updateQuestion(questionDTO, id));

        verify(Repoquestion, times(1)).findById(id);
        verify(Repoquestion, times(0)).save(any(Question.class));
    }
    @Test
    void testGetOne() {
        long id = 1L;
        Optional<Question> optionalQuestion = Optional.of(question);

        when(Repoquestion.findById(id)).thenReturn(optionalQuestion);

        Optional<Question> result = questionService.getOne(id);

        verify(Repoquestion, times(1)).findById(id);
        assertTrue(result.isPresent());

        assertEquals(question.getId(), result.get().getId());
        assertEquals(question.getText(), result.get().getText());

        assertEquals(question.getType(), result.get().getType());
    }


}
