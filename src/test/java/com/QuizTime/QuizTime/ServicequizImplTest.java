package com.QuizTime.QuizTime;

import com.QuizTime.QuizTime.exception.CustomException;
import com.QuizTime.QuizTime.model.entity.Quiz;
import com.QuizTime.QuizTime.model.entity.Teacher;
import com.QuizTime.QuizTime.model.entity.dto.QuizDTO;
import com.QuizTime.QuizTime.model.entity.dto.TeacherDTO;
import com.QuizTime.QuizTime.repository.quizRepository;
import com.QuizTime.QuizTime.repository.teacherRepository;
import com.QuizTime.QuizTime.service.serviceImpl.quizServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServicequizImplTest {

    @Mock
    private quizRepository repoQuiz;

    @Mock
    private teacherRepository repoTeacher;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private quizServiceImpl quizService;

    private QuizDTO quizDTO;
    private Quiz quiz;
    private TeacherDTO teacherDTO;
    private Teacher teacher;

    @BeforeEach
    public void setUp() {

        teacher = new Teacher();
        teacher.setId(1L);
        teacher.setFirstName("you");
        teacher.setLastName("code");
        teacher.setDateOfBirth(LocalDate.now());
        teacher.setAddress("safi");
        teacher.setSpeciality("java coach");

        teacherDTO = new TeacherDTO();
        teacherDTO.setId(1L);
        teacherDTO.setFirstName("you");
        teacherDTO.setLastName("code");
        teacherDTO.setDateOfBirth(LocalDate.now());
        teacherDTO.setAddress("safi");
        teacherDTO.setSpeciality("java coach");

        quiz = Quiz.builder()
                .id(1L)
                .title("Quiz test")
                .start_Date(LocalDateTime.now())
                .end_Date(LocalDateTime.now().plusHours(2))
                .remarks("remarque test")
                .successScore("80")
                .maxAttempts(2)
                .instructions("instruction test")
                .teacher(teacher)
                .build();

        quizDTO = new QuizDTO();
        quizDTO.setId(1L);
        quizDTO.setTitle("Quiz test");
        quizDTO.setStart_Date(LocalDateTime.now());
        quizDTO.setEnd_Date(LocalDateTime.now().plusHours(2));
        quizDTO.setRemarks("remarque test");
        quizDTO.setSuccessScore("80");
        quizDTO.setMaxAttempts(2);
        quizDTO.setInstructions("instruction test");
        quizDTO.setTeacher_id(teacherDTO.getId());


    }

    @Test
    public void testSaveQuiz() {
        given(repoTeacher.findById(quizDTO.getTeacher_id())).willReturn(Optional.of(teacher));
        given(modelMapper.map(quizDTO, Quiz.class)).willReturn(quiz);
        given(modelMapper.map(quiz, QuizDTO.class)).willReturn(quizDTO);
        given(repoQuiz.save(quiz)).willReturn(quiz);
        QuizDTO savedQuiz = quizService.saveQuiz(quizDTO);
        assertThat(savedQuiz).isNotNull();
    }

    @Test
    public void testGetAllQuiz() {
        int page = 0;
        int size = 10;
        Pageable pageable = PageRequest.of(page, size);
        Page<Quiz> mockPage = new PageImpl<>(List.of(quiz));
        given(repoQuiz.findAll(pageable)).willReturn(mockPage);

        List<QuizDTO> quizList = quizService.getAllQuiz(page, size);

        assertThat(quizList).isNotEmpty();
        assertThat(quizList.size()).isEqualTo(1);

    }

    @Test
    public void testDeleteQuiz() {

        Long quizId = 1L;
        given(repoQuiz.findById(quizId)).willReturn(Optional.of(quiz));
        willDoNothing().given(repoQuiz).delete(quiz);

        quizService.deleteQuiz(quizId);

        verify(repoQuiz, times(1)).findById(quizId);
        verify(repoQuiz, times(1)).delete(quiz);
    }


    @Test
    public void testGetAllQuizEmptyList() {
        // Arrange
        int page = 0;
        int size = 10;
        Pageable pageable = PageRequest.of(page, size);
        Page<Quiz> mockPage = new PageImpl<>(List.of()); // Liste vide de quiz
        given(repoQuiz.findAll(pageable)).willReturn(mockPage);

        // Act
        List<QuizDTO> quizList = quizService.getAllQuiz(page, size);

        // Assert
        assertThat(quizList).isEmpty();
    }

    @Test
    public void testRepoQuizSaveReturnsNull() {
        // Arrange
        given(repoTeacher.findById(quizDTO.getTeacher_id())).willReturn(Optional.of(teacher));
        given(modelMapper.map(quizDTO, Quiz.class)).willReturn(quiz);
        given(repoQuiz.save(quiz)).willReturn(null); // Simuler le cas où RepoQuiz.save renvoie null

        // Act
        QuizDTO savedQuiz = quizService.saveQuiz(quizDTO);

        // Assert
        assertThat(savedQuiz).isNull();
    }




    @Test
    public void testSaveQuizWithNonExistingTeacher() {
        // Arrange
        quizDTO.setTeacher_id(999L); // Simulation d'un enseignant non existant
        given(repoTeacher.findById(quizDTO.getTeacher_id())).willReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> quizService.saveQuiz(quizDTO))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining("The trainer with id 999 is not found");
    }


    @Test
    public void testSaveQuizWithExistingId() {
        // Arrange
        quizDTO.setId(1L); // Simulation d'un ID existant
        given(repoTeacher.findById(quizDTO.getTeacher_id())).willReturn(Optional.of(teacher));
        given(modelMapper.map(quizDTO, Quiz.class)).willReturn(quiz);
        given(modelMapper.map(quiz, QuizDTO.class)).willReturn(quizDTO);
        given(repoQuiz.save(quiz)).willReturn(quiz);

        // Act
        QuizDTO savedQuiz = quizService.saveQuiz(quizDTO);

        // Assert
        assertThat(savedQuiz).isNotNull();
        assertThat(savedQuiz.getId()).isEqualTo(quizDTO.getId());
        // Ajoutez d'autres assertions en fonction des propriétés que vous vous attendez à être présentes
    }


    @Test
    public void testFindByIdWhenQuizExists() {
        // Arrange
        Long quizId = 1L;
        given(repoQuiz.findById(quizId)).willReturn(Optional.of(quiz));
        given(modelMapper.map(quiz, QuizDTO.class)).willReturn(quizDTO);

        // Act
        QuizDTO foundQuiz = quizService.findByID(quizId);

        // Assert
        assertThat(foundQuiz).isNotNull();
        assertThat(foundQuiz.getId()).isEqualTo(quizId);
    }

    @Test
    public void testFindByIdWhenQuizDoesNotExist() {
        // Arrange
        Long nonExistingQuizId = 99L;
        given(repoQuiz.findById(nonExistingQuizId)).willReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> quizService.findByID(nonExistingQuizId))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining("The quiz with id 99 is not found");
    }




}
