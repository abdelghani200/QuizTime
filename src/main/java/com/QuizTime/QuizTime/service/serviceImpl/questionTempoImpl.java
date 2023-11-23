package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.exception.CustomException;
import com.QuizTime.QuizTime.helpers.TemporationId;
import com.QuizTime.QuizTime.model.entity.Question;
import com.QuizTime.QuizTime.model.entity.QuestionTemporation;
import com.QuizTime.QuizTime.model.entity.Quiz;
import com.QuizTime.QuizTime.model.entity.dto.QuestionTempoDTO;
import com.QuizTime.QuizTime.repository.tempoRepository;
import com.QuizTime.QuizTime.service.serviceInterface.questionTempo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class questionTempoImpl implements questionTempo {

    @Autowired
    private tempoRepository RepoTempo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuestionTempoDTO saveTempoQuestion(QuestionTempoDTO questionTempoDTO) {
        QuestionTemporation questionTemporation = modelMapper.map(questionTempoDTO, QuestionTemporation.class);
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

        // Update the existing QuestionTempo with the new values
        existingTempo.setTime(tempoQuizDto.getTime());

        // Save the updated QuestionTempo
        QuestionTemporation updatedTempo = RepoTempo.save(existingTempo);

        // Map and return the updated QuestionTempoDTO
        return modelMapper.map(updatedTempo, QuestionTempoDTO.class);
    }
}
