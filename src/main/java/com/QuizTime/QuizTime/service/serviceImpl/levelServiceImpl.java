package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.exception.CustomException;
import com.QuizTime.QuizTime.exception.ExceptionLevel;
import com.QuizTime.QuizTime.model.entity.Level;
import com.QuizTime.QuizTime.model.entity.dto.LevelDTO;
import com.QuizTime.QuizTime.repository.levelRepository;
import com.QuizTime.QuizTime.service.serviceInterface.levelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class levelServiceImpl implements levelService {

    @Autowired
    private levelRepository Repo_level;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<LevelDTO> getAllLevels() {
        List<Level> levels = Repo_level.findAll();
        return levels.stream()
                .map(level -> modelMapper.map(level, LevelDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteLevel(Long id) {
        Repo_level.deleteById(id);
    }

    @Override
    public LevelDTO saveLevel(LevelDTO levelDTO) {
        Level level = modelMapper.map(levelDTO, Level.class);
        Level savedLevel = Repo_level.save(level);
        return modelMapper.map(savedLevel, LevelDTO.class);
    }

    @Override
    public LevelDTO updateLevel(LevelDTO levelDTO, Long id) {
        Optional<Level> existingLevelOptional = Repo_level.findById(id);
        if (existingLevelOptional.isEmpty()) {
            throw new CustomException("Level not found with ID: " + id);
        }

        Level existingLevel = existingLevelOptional.get();
        modelMapper.map(levelDTO, existingLevel);
        Level updatedLevel = Repo_level.save(existingLevel);
        return modelMapper.map(updatedLevel, LevelDTO.class);
    }

    @Override
    public Optional<LevelDTO> getById(Long id) {
        Optional<Level> level = Repo_level.findById(id);
        return level.map(value -> modelMapper.map(value, LevelDTO.class));
    }

    @Override
    public Page<LevelDTO> getLevels(Pageable pageable) {
        return Repo_level.findAll(pageable).map(competition -> modelMapper.map(competition, LevelDTO.class));
    }
}

