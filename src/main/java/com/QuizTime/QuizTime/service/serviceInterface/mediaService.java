package com.QuizTime.QuizTime.service.serviceInterface;

import com.QuizTime.QuizTime.helpers.MediaResDTO;
import com.QuizTime.QuizTime.model.entity.dto.MediaDTO;
import com.QuizTime.QuizTime.model.entity.dto.QuestionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface mediaService {

    MediaDTO saveMedia(MediaDTO mediaDTO);

    List<MediaResDTO> getAll();

    void delete(Integer id);

}
