package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.model.entity.Level;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface levelService {

    List<Level> getAllLevels();

}


