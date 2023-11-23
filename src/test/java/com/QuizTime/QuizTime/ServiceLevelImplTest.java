package com.QuizTime.QuizTime;

import com.QuizTime.QuizTime.exception.ExceptionLevel;
import com.QuizTime.QuizTime.model.entity.Level;
import com.QuizTime.QuizTime.model.entity.dto.LevelDTO;
import com.QuizTime.QuizTime.repository.levelRepository;
import com.QuizTime.QuizTime.service.serviceImpl.levelServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceLevelImplTest {

    @Mock
    private levelRepository repoLevel;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private levelServiceImpl levelService;

    private Level level;

    private LevelDTO levelDTO;

    private Level existingLevel;
    @BeforeEach
    void setUp() {
        level = Level.builder()
                .id(1L)
                .description("level description")
                .maxPoints(30.00)
                .minPoints(5.00)
                .build();

        levelDTO = new LevelDTO();
        levelDTO.setId(1L);
        levelDTO.setDescription("level dto description");
        levelDTO.setMaxPoints(30.00);
        levelDTO.setMinPoints(5.00);

        existingLevel = Level.builder()
                .id(1L)
                .description("level description")
                .maxPoints(30.00)
                .minPoints(5.00)
                .build();
    }


    @Test
    void testGetAllLevels() {
        // Mocking the repository response
        when(repoLevel.findAll()).thenReturn(Arrays.asList(
                level, // use the already created level
                createLevel(2L, "Medium"),
                createLevel(3L, "Hard")
        ));

        List<LevelDTO> result = levelService.getAllLevels();

        assertEquals(3, result.size());

        // Verifying that the repository method was called
        verify(repoLevel, times(1)).findAll();
    }


    @Test
    void testDeleteLevel() {
        // Mocking the repository method
        doNothing().when(repoLevel).deleteById(1L);

        levelService.deleteLevel(1L);

        // Verifying that the repository method was called
        verify(repoLevel, times(1)).deleteById(1L);
    }

    @Test
    void testGetById() {
        Long levelID = 1L;

        given(repoLevel.findById(levelID)).willReturn(Optional.of(level));
        given(modelMapper.map(level, LevelDTO.class)).willReturn(levelDTO);

        Optional<LevelDTO> foundLevel = levelService.getById(levelID);

        verify(repoLevel).findById(levelID);

        assertThat(foundLevel).isNotNull();
    }


    private Level createLevel(Long id, String description) {
        Level level = new Level();

        level.setId(id);
        level.setDescription(description);
        return level;
    }

    @Test
    void testFindByIdNotFound() {
        Long invalidLevelID = 99L;

        given(repoLevel.findById(invalidLevelID)).willReturn(Optional.empty());

        Optional<LevelDTO> foundLevel = levelService.getById(invalidLevelID);

        verify(repoLevel).findById(invalidLevelID);

        assertThat(foundLevel).isEmpty();
    }





}
