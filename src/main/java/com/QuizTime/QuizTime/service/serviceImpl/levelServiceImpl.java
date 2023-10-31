package com.QuizTime.QuizTime.service.serviceImpl;

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
    public void deleteLevel(Integer id) {
        Repo_level.deleteById(id);
    }

    @Override
    public Level saveLevel( Level level) {
        return Repo_level.save(level);
    }

    @Override
    public Optional<Level> getOne(Integer id) {
        return Repo_level.findById(id);
    }
}
