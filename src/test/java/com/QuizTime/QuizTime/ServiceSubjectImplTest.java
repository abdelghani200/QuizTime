package com.QuizTime.QuizTime;

import com.QuizTime.QuizTime.exception.ExceptionSubject;
import com.QuizTime.QuizTime.model.entity.Answer;
import com.QuizTime.QuizTime.model.entity.Subject;
import com.QuizTime.QuizTime.repository.subjectRepository;
import com.QuizTime.QuizTime.service.serviceImpl.subjectServiceImpl;
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
public class ServiceSubjectImplTest {

    @Mock
    private subjectRepository RepoSubject;

    @InjectMocks
    private subjectServiceImpl subjectService;

    @Test
    void testGetAllSubjects() {
        when(RepoSubject.findAll()).thenReturn(List.of(new Subject(), new Subject()));

        var result = subjectService.getAllSubjects();

        assertEquals(2, result.size());
    }

    @Test
    void testSaveSubject() {
        Subject subjectToSave = new Subject();

        when(RepoSubject.save(subjectToSave)).thenReturn(subjectToSave);

        Subject savedSubject = subjectService.saveSubject(subjectToSave);

        assertNotNull(savedSubject);
        assertEquals(subjectToSave, savedSubject);
    }

    @Test
    void testUpdateSubject() throws ExceptionSubject {
        Integer id = 1 ;

        Subject existingSubject = new Subject();
        Subject updateSubject = new Subject();

        updateSubject.setTitle("Update Title");

        when(RepoSubject.findById(id)).thenReturn(Optional.of(existingSubject));
        when(RepoSubject.save(existingSubject)).thenReturn(updateSubject);

        Subject result = subjectService.updateSubject(updateSubject, id);

        assertNotNull(result);
        assertEquals(updateSubject.getTitle(), result.getTitle());

    }

    @Test
    void testDeleteSubject() {
        Integer id = 1;
        subjectService.deleteSubject(id);

        verify(RepoSubject, times(1)).deleteById(id);
    }


}
