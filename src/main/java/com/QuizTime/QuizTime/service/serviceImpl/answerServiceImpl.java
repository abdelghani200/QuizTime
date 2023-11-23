package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.exception.CustomException;
import com.QuizTime.QuizTime.exception.ExceptionAnswer;
import com.QuizTime.QuizTime.exception.ExceptionLevel;
import com.QuizTime.QuizTime.exception.ExceptionQuestion;
import com.QuizTime.QuizTime.model.entity.Answer;
import com.QuizTime.QuizTime.model.entity.Level;
import com.QuizTime.QuizTime.model.entity.Question;
import com.QuizTime.QuizTime.model.entity.dto.AnswerDTO;
import com.QuizTime.QuizTime.model.entity.dto.LevelDTO;
import com.QuizTime.QuizTime.model.entity.dto.QuestionDTO;
import com.QuizTime.QuizTime.repository.answerRepository;
import com.QuizTime.QuizTime.service.serviceInterface.answerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class answerServiceImpl implements answerService {

    @Autowired
    private answerRepository RepoAnswer;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<AnswerDTO> getAllAnswers() {
        List<Answer> answers = RepoAnswer.findAll();
        return answers.stream()
                .map(answer -> modelMapper.map(answer, AnswerDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public AnswerDTO saveAnswer(AnswerDTO answerDTO) {
        Answer answer = modelMapper.map(answerDTO, Answer.class);
        Answer savedAnswer = RepoAnswer.save(answer);
        return modelMapper.map(savedAnswer, AnswerDTO.class);
    }


    @Override
    public void deleteAnswer(Long id) {
        RepoAnswer.deleteById(id);
    }


    @Override
    public AnswerDTO updateAnswer(AnswerDTO answerDTO, long id) {
        Optional<Answer> existingAnswerOptional = RepoAnswer.findById(id);

        if (existingAnswerOptional.isEmpty()) {
            throw new CustomException("The answer with id " + id + " does not exist");
        }

        Answer existingAnswer = existingAnswerOptional.get();

        existingAnswer.setAnswerText(answerDTO.getAnswerText());

        Answer updatedAnswer = RepoAnswer.save(existingAnswer);

        return modelMapper.map(updatedAnswer, AnswerDTO.class);
    }



    @Override
    public AnswerDTO findByID(Long id) {
        Answer response = RepoAnswer.findById(id).orElseThrow(()
                -> new CustomException("The response with id " + id + " does not exist"));
        return modelMapper.map(response, AnswerDTO.class);
    }

}
