package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.model.entity.Media;
import com.QuizTime.QuizTime.model.entity.Question;
import com.QuizTime.QuizTime.model.entity.dto.MediaDTO;
import com.QuizTime.QuizTime.repository.mediaRepository;
import com.QuizTime.QuizTime.service.serviceInterface.mediaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class mediaServiceImpl implements mediaService {

    @Autowired
    private mediaRepository RepoMedia;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MediaDTO saveMedia(MediaDTO mediaDTO) {
        Media media = modelMapper.map(mediaDTO, Media.class);
        Media savedMedia = RepoMedia.save(media);

        return modelMapper.map(savedMedia, MediaDTO.class);
    }
}
