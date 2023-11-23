package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.exception.CustomException;
import com.QuizTime.QuizTime.exception.ExceptionAnswer;
import com.QuizTime.QuizTime.exception.ExceptionQuestion;
import com.QuizTime.QuizTime.model.entity.Answer;
import com.QuizTime.QuizTime.model.entity.Question;
import com.QuizTime.QuizTime.model.entity.Validation;
import com.QuizTime.QuizTime.model.entity.dto.AnswerDTO;
import com.QuizTime.QuizTime.model.entity.dto.AnswerQuestionDTO;
import com.QuizTime.QuizTime.model.entity.dto.ValidationDTO;
import com.QuizTime.QuizTime.repository.validationRepository;
import com.QuizTime.QuizTime.service.serviceInterface.answerService;
import com.QuizTime.QuizTime.service.serviceInterface.questionService;
import com.QuizTime.QuizTime.service.serviceInterface.validationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class validationServiceImpl implements validationService {

    @Autowired
    private validationRepository repoValidation;

    @Autowired
    private questionService serviceQuestion;

    @Autowired
    private answerService serviceAnswer;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ValidationDTO save(ValidationDTO validationDto) {
        Validation validation = modelMapper.map(validationDto, Validation.class);

        AnswerQuestionDTO question = serviceQuestion.findByID(validationDto.getQuestion_id());
        AnswerDTO answer = serviceAnswer.findByID(validationDto.getResponse_id());

        validation.setQuestion(modelMapper.map(question, Question.class));
        validation.setAnswer(modelMapper.map(answer, Answer.class));

        validation = repoValidation.save(validation);

        return modelMapper.map(validation, ValidationDTO.class);
    }
}
