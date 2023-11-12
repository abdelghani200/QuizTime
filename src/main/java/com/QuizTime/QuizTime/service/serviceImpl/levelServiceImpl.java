package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.exception.ExceptionLevel;
import com.QuizTime.QuizTime.model.entity.Level;
import com.QuizTime.QuizTime.repository.levelRepository;
import com.QuizTime.QuizTime.service.serviceInterface.levelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class levelServiceImpl implements levelService {

    @Autowired
    private levelRepository Repo_level;

    @Override
    public List<Level> getAllLevels() {
        return Repo_level.findAll();
    }

    @Override
    public void deleteLevel(Long id) {
        Repo_level.deleteById(id);
    }

    @Override
    public Level saveLevel( Level level) {
        return Repo_level.save(level);
    }

    @Override
    public Optional<Level> getOne(Long id) {
        return Repo_level.findById(id);
    }

    @Override
    public Level updateLevel(Level level, Long id) throws ExceptionLevel {
        return Repo_level.findById(id)
                .map(existingLevel -> {
                    existingLevel.setDescription(level.getDescription());
                    existingLevel.setMaxPoints(level.getMaxPoints());
                    existingLevel.setMinPoints(level.getMinPoints());
                    return Repo_level.save(existingLevel);
                })
                .orElseThrow(() -> new ExceptionLevel("Level not found with ID: " + id));
    }

}
