package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.exception.CustomException;
import com.QuizTime.QuizTime.model.entity.dto.AnswerQuestionDTO;
import com.QuizTime.QuizTime.model.entity.Media;
import com.QuizTime.QuizTime.model.entity.Question;
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

    @Transactional
    @Override
    public QuestionDTO saveQuestion(QuestionDTO questionDTO) {

        Question question = modelMapper.map(questionDTO, Question.class);

        if (questionDTO.getMedias() != null) {
            for (MediaDTO mediaDTO : questionDTO.getMedias()) {
                mediaDTO.setQuestionDTO(questionDTO);
            }
        }

        assert questionDTO.getMedias() != null;
        List<Media> mediaList = questionDTO.getMedias()
                .stream()
                .map(mediaDTO -> modelMapper.map(mediaDTO, Media.class))
                .collect(Collectors.toList());

        mediaList.forEach(media -> media.setQuestion(question));

        question.setMedias(mediaList);
        Question savedQuestion = Repoquestion.save(question);

        return mapQuestionToQuestionDTO(savedQuestion);
    }
    private QuestionDTO mapQuestionToQuestionDTO(Question question) {
        QuestionDTO questionDTO = modelMapper.map(question, QuestionDTO.class);

        questionDTO.setMedias(
                question.getMedias()
                        .stream()
                        .map(media -> modelMapper.map(media, MediaDTO.class))
                        .collect(Collectors.toList())
        );
        return questionDTO;
    }

    @Override
    public QuestionDTO updateQuestion(QuestionDTO questionDTO, long id) {
        Optional<Question> optionalQuestion = Repoquestion.findById(id);
        if (optionalQuestion.isEmpty()) {
            throw new CustomException("Question not found with ID: " + id);
        }
        Question existingQuestion = optionalQuestion.get();

        // Update only the fields you want to change
        existingQuestion.setText(questionDTO.getText());
        existingQuestion.setAnswerNumber(questionDTO.getAnswerNumber());
        // Update other fields as needed

        Question updatedQuestion = Repoquestion.save(existingQuestion);

        return modelMapper.map(updatedQuestion, QuestionDTO.class);
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






}
