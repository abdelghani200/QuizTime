package com.QuizTime.QuizTime.service.serviceImpl;

import com.QuizTime.QuizTime.exception.ExceptionQuestion;
import com.QuizTime.QuizTime.model.entity.Question;
import com.QuizTime.QuizTime.model.entity.dto.QuestionDTO;
import com.QuizTime.QuizTime.repository.levelRepository;
import com.QuizTime.QuizTime.repository.questionRepository;
import com.QuizTime.QuizTime.repository.subjectRepository;
import com.QuizTime.QuizTime.service.serviceInterface.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
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
    private subjectRepository Reposubject;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<QuestionDTO> getAllQuestions() {
        List<Question> questions = Repoquestion.findAll();
        return questions.stream()
                .map(question -> modelMapper.map(question, QuestionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public QuestionDTO saveQuestion(QuestionDTO questionDTO) {
        Question question = modelMapper.map(questionDTO, Question.class);
        Question savedQuestion = Repoquestion.save(question);
        return modelMapper.map(savedQuestion, QuestionDTO.class);
    }

    @Override
    public QuestionDTO updateQuestion(QuestionDTO questionDTO, long id) throws ExceptionQuestion {
        Optional<Question> optionalQuestion = Repoquestion.findById(id);
        if (optionalQuestion.isPresent()){
            throw  new ExceptionQuestion("Question not founr with ID: " + id);
        }
        Question existingQuestion = optionalQuestion.get();

        modelMapper.map(questionDTO, existingQuestion);

        Question updatedQuestion = Repoquestion.save(existingQuestion);

        return modelMapper.map(updatedQuestion, QuestionDTO.class);
    }

    @Override
    public void deleteQuestion(long id){
        Repoquestion.deleteById(id);
    }


    @Override
    public Optional<Question> getOne(long id) {
        return Repoquestion.findById(id);
    }






}
