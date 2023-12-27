package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.exception.CustomException;
import com.QuizTime.QuizTime.helpers.MediaResDTO;
import com.QuizTime.QuizTime.model.entity.Media;
import com.QuizTime.QuizTime.model.entity.Question;
import com.QuizTime.QuizTime.model.entity.dto.MediaDTO;
import com.QuizTime.QuizTime.repository.mediaRepository;
import com.QuizTime.QuizTime.repository.questionRepository;
import com.QuizTime.QuizTime.service.serviceInterface.mediaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class mediaServiceImpl implements mediaService {

    @Autowired
    private mediaRepository RepoMedia;

    @Autowired
    private questionRepository RepoQuestion;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MediaDTO saveMedia(MediaDTO mediaDTO) {
        Media media = modelMapper.map(mediaDTO, Media.class);
        if (mediaDTO.getQuestion_id()  != null) {
            Question question = RepoQuestion.findById(mediaDTO.getQuestion_id())
                    .orElseThrow(() -> new CustomException("Question not found"));
            media.setQuestion(question);
        }
        media = RepoMedia.save(media);
        return modelMapper.map(media, MediaDTO.class);
    }

    @Override
    public List<MediaResDTO> getAll() {
        List<Media> medias = RepoMedia.findAll();
        return medias.stream()
                .map(media -> modelMapper.map(media, MediaResDTO.class))
                .toList();
    }

    @Override
    public void delete(Integer id) {
        Media media = RepoMedia.findById(id)
                .orElseThrow(() -> new CustomException("The media with id " + id + " is not found"));
        RepoMedia.delete(media);
    }
}
