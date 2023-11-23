package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.model.entity.dto.MediaDTO;
import com.QuizTime.QuizTime.model.entity.dto.QuestionDTO;
import org.springframework.stereotype.Service;

@Service
public interface mediaService {

    MediaDTO saveMedia(MediaDTO mediaDTO);

}
