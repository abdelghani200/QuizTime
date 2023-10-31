package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.model.entity.Level;
import com.QuizTime.QuizTime.repository.levelRepository;
import com.QuizTime.QuizTime.service.serviceInterface.levelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class levelServiceImpl implements levelService {

    @Autowired
    private levelRepository Repo_level;

    @Override
    public List<Level> getAllLevels() {
        return Repo_level.findAll();
    }
}
