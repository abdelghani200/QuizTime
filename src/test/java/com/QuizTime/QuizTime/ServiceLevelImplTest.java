package com.QuizTime.QuizTime;

import com.QuizTime.QuizTime.exception.ExceptionLevel;
import com.QuizTime.QuizTime.model.entity.Level;
import com.QuizTime.QuizTime.repository.levelRepository;
import com.QuizTime.QuizTime.service.serviceImpl.levelServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceLevelImplTest {

    @Mock
    private levelRepository RepoLevel;

    @InjectMocks
    private levelServiceImpl levelService;

    @Test
    void testGetAllLevels() {
        // Arrange
        when(RepoLevel.findAll()).thenReturn(List.of(new Level(), new Level()));

        // Act
        var result = levelService.getAllLevels();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    void testDeleteLeve() {
        long id = 1;
        levelService.deleteLevel(id);

        verify(RepoLevel, times(1)).deleteById(id);
    }

    @Test
    void testSaveLevel() {
        Level levelToSave = new Level();

        when(RepoLevel.save(levelToSave)).thenReturn(levelToSave);

        Level savedLevel = levelService.saveLevel(levelToSave);

        assertNotNull(savedLevel);
        assertEquals(levelToSave, savedLevel);
    }

    @Test
    void testGetOne() {
        long id = 1;

        Level level = new Level();

        when(RepoLevel.findById(id)).thenReturn(Optional.of(level));

        Optional<Level> result = levelService.getOne(id);

        assertTrue(result.isPresent());
        assertEquals(level, result.get());
    }

    @Test
    void testUpdateLevel() throws ExceptionLevel {
        long id = 1;
        Level existingLevel = new Level();
        Level updatedLevel = new Level();

        updatedLevel.setDescription("Updated Description");

        when(RepoLevel.findById(id)).thenReturn(Optional.of(existingLevel));
        when(RepoLevel.save(existingLevel)).thenReturn(updatedLevel);

        Level result = levelService.updateLevel(updatedLevel, id);

        assertNotNull(result);
        assertEquals(updatedLevel.getDescription(), result.getDescription());

    }

    @Test
    void testUpdateLevel_LevelNotFound() {
        long id = 1;

        Level updatedLevel = new Level();

        updatedLevel.setDescription("Updated Description");

        when(RepoLevel.findById(id)).thenReturn(Optional.empty());

        assertThrows(ExceptionLevel.class, () -> levelService.updateLevel(updatedLevel, id));
    }



}
