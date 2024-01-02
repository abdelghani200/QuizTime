package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.exception.ExceptionLevel;
import com.QuizTime.QuizTime.model.entity.Level;
import com.QuizTime.QuizTime.model.entity.dto.LevelDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface levelService {

    List<LevelDTO> getAllLevels();
    void deleteLevel(Long id);
    LevelDTO saveLevel(LevelDTO levelDTO);
    Optional<LevelDTO> getById(Long id);
    LevelDTO updateLevel(LevelDTO levelDTO, Long id);
    Page<LevelDTO> getLevels(Pageable pageable);

}


