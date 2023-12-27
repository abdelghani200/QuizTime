package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.exception.CustomException;
import com.QuizTime.QuizTime.helpers.MediaResDTO;
import com.QuizTime.QuizTime.helpers.QuestionResDTO;
import com.QuizTime.QuizTime.model.entity.Level;
import com.QuizTime.QuizTime.model.entity.Subject;
import com.QuizTime.QuizTime.model.entity.dto.AnswerQuestionDTO;
import com.QuizTime.QuizTime.model.entity.Media;
import com.QuizTime.QuizTime.model.entity.Question;
import com.QuizTime.QuizTime.model.entity.dto.LevelDTO;
import com.QuizTime.QuizTime.model.entity.dto.MediaDTO;
import com.QuizTime.QuizTime.model.entity.dto.QuestionDTO;
import com.QuizTime.QuizTime.repository.levelRepository;
import com.QuizTime.QuizTime.repository.mediaRepository;
import com.QuizTime.QuizTime.repository.questionRepository;
import com.QuizTime.QuizTime.repository.subjectRepository;
import com.QuizTime.QuizTime.service.serviceInterface.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class questionServiceImpl implements questionService {

    @Autowired
    private questionRepository Repoquestion;

    @Autowired
    private levelRepository Repolevel;

    @Autowired
    private mediaRepository RepoMedia;

    @Autowired
    private subjectRepository Reposubject;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<QuestionDTO> getAllQuestions(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Question> questions = Repoquestion.findAll(pageable);

        return questions.getContent().stream()
                .map(question -> modelMapper.map(question, QuestionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<QuestionDTO> AllQuestions() {
        List<Question> questions = Repoquestion.findAll();
        return questions.stream()
                .map(question -> modelMapper.map(question, QuestionDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public QuestionResDTO saveQuestion(QuestionResDTO questionResDTO) {

        Question question = modelMapper.map(questionResDTO, Question.class);

        if (questionResDTO.getLevel_id() != null) {
            Level level = Repolevel.findById(questionResDTO.getLevel_id())
                    .orElseThrow(() -> new CustomException("Level not found"));
            question.setLevel(level);
        }

        if (questionResDTO.getSubject_id() != null) {
            Subject subject = Reposubject.findById(questionResDTO.getSubject_id())
                    .orElseThrow(() -> new CustomException("Subject not found"));
            question.setSubject(subject);
        }

        if (questionResDTO.getMedias() != null) {
            for (MediaDTO mediaDTO : questionResDTO.getMedias()) {
                mediaDTO.setQuestionDTO(questionResDTO);
            }
        }

        assert questionResDTO.getMedias() != null;
        List<Media> mediaList = questionResDTO.getMedias()
                .stream()
                .map(mediaDTO -> modelMapper.map(mediaDTO, Media.class))
                .collect(Collectors.toList());

        mediaList.forEach(media -> media.setQuestion(question));

        question.setMedias(mediaList);
        Question savedQuestion = Repoquestion.save(question);

        return mapQuestionToQuestionDTO(savedQuestion);
    }


    private QuestionResDTO mapQuestionToQuestionDTO(Question question) {
        QuestionResDTO questionDTO = modelMapper.map(question, QuestionResDTO.class);

        questionDTO.setMedias(
                question.getMedias()
                        .stream()
                        .map(media -> modelMapper.map(media, MediaDTO.class))
                        .collect(Collectors.toList())
        );
        return questionDTO;
    }

    @Override
    public QuestionResDTO updateQuestion(QuestionResDTO questionDTO, long id) {
        Optional<Question> optionalQuestion = Repoquestion.findById(id);
        if (optionalQuestion.isEmpty()) {
            throw new CustomException("Question not found with ID: " + id);
        }
        Question existingQuestion = optionalQuestion.get();


        existingQuestion.setText(questionDTO.getText());
        existingQuestion.setAnswerNumber(questionDTO.getAnswerNumber());
        existingQuestion.setScorePoints(questionDTO.getScorePoints());

        if (questionDTO.getLevel_id() != null) {
            Level level = Repolevel.findById(questionDTO.getLevel_id())
                    .orElseThrow(() -> new CustomException("Level not found"));
            existingQuestion.setLevel(level);
        }

        if (questionDTO.getSubject_id() != null) {
            Subject subject = Reposubject.findById(questionDTO.getSubject_id())
                    .orElseThrow(() -> new CustomException("Subject not found"));
            existingQuestion.setSubject(subject);
        }

        Question updatedQuestion = Repoquestion.save(existingQuestion);

        return modelMapper.map(updatedQuestion, QuestionResDTO.class);
    }


    @Override
    public void deleteQuestion(long id){
        Repoquestion.deleteById(id);
    }

    @Override
    public AnswerQuestionDTO findByID(Long id) {
        Question question = Repoquestion.findById(id)
                .orElseThrow(() -> new CustomException("The question with ID " + id + " does not exist"));

        return modelMapper.map(question, AnswerQuestionDTO.class);
    }

    @Override
    public List<MediaResDTO> getAllMedia() {
        List<Media> mediaList = RepoMedia.findAll();
        return mediaList.stream()
                .map(media -> modelMapper.map(media, MediaResDTO.class))
                .collect(Collectors.toList());
    }





}
