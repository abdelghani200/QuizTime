package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.exception.CustomException;
import com.QuizTime.QuizTime.helpers.MediaResDTO;
import com.QuizTime.QuizTime.helpers.TempoQuestionRes;
import com.QuizTime.QuizTime.helpers.TemporationId;
import com.QuizTime.QuizTime.helpers.ValidationRes;
import com.QuizTime.QuizTime.model.entity.Media;
import com.QuizTime.QuizTime.model.entity.Question;
import com.QuizTime.QuizTime.model.entity.QuestionTemporation;
import com.QuizTime.QuizTime.model.entity.Quiz;
import com.QuizTime.QuizTime.model.entity.dto.QuestionTempoDTO;
import com.QuizTime.QuizTime.model.entity.dto.QuizDTO;
import com.QuizTime.QuizTime.repository.tempoRepository;
import com.QuizTime.QuizTime.service.serviceInterface.questionTempo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class questionTempoImpl implements questionTempo {

    @Autowired
    private tempoRepository RepoTempo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuestionTempoDTO saveTempoQuestion(QuestionTempoDTO questionTempoDTO) {

        QuestionTemporation questionTemporation = modelMapper.map(questionTempoDTO, QuestionTemporation.class);

        TemporationId temporationId = new TemporationId();
        temporationId.setQuiz(questionTempoDTO.getQuiz_id());
        temporationId.setQuestion(questionTempoDTO.getQuestion_id());
        questionTemporation.setId(temporationId);

        QuestionTemporation savedTempoQuestion = RepoTempo.save(questionTemporation);

        return modelMapper.map(savedTempoQuestion, QuestionTempoDTO.class);
    }


    @Override
    public void delete(Long questionID, Long quizID) {
        TemporationId temporationId = new TemporationId(quizID, questionID);
        QuestionTemporation questionTemporation = RepoTempo.findById(temporationId)
                .orElseThrow(() -> new CustomException("The tempo quiz with id " + temporationId + " is not found"));
        RepoTempo.delete(questionTemporation);
    }

    @Override
    public QuestionTempoDTO update(Long questionID, QuestionTempoDTO tempoQuizDto) {

        TemporationId temporationId = new TemporationId(tempoQuizDto.getQuiz_id(), questionID);


        QuestionTemporation existingTempo = RepoTempo.findById(temporationId)
                .orElseThrow(() -> new CustomException("Question Tempo with id " + temporationId + " not found"));

        existingTempo.setTime(tempoQuizDto.getTime());

        QuestionTemporation updatedTempo = RepoTempo.save(existingTempo);

        return modelMapper.map(updatedTempo, QuestionTempoDTO.class);
    }

    @Override
    public List<TempoQuestionRes> getAllTempoQuestions() {
        List<QuestionTemporation> questionTemporations = RepoTempo.findAll();
        return questionTemporations.stream()
                .map(allTempoQuestions -> modelMapper.map(allTempoQuestions, TempoQuestionRes.class))
                .toList();
    }
    @Override
    public List<TempoQuestionRes> getTempoQuestionsForQuiz(Long quizID) {
        List<QuestionTemporation> questionTemporations = RepoTempo.findAllById_Quiz(quizID);
        return questionTemporations.stream()
                .map(tempoQuestion -> modelMapper.map(tempoQuestion, TempoQuestionRes.class))
                .toList();
    }

}
