package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.model.entity.Level;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface levelService {

    List<Level> getAllLevels();
    void deleteLevel(Integer id);

    Level saveLevel(Level level);

    Optional<Level> getOne(Integer id);

}


