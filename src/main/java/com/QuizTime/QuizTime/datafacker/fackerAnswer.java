package com.QuizTime.QuizTime.datafacker;

import com.QuizTime.QuizTime.model.entity.Answer;
import com.QuizTime.QuizTime.model.entity.Question;
import com.QuizTime.QuizTime.repository.answerRepository;
import com.QuizTime.QuizTime.repository.questionRepository;
import jakarta.annotation.PostConstruct;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class fackerAnswer {

    private final Faker faker;
    private final answerRepository Repo_answer;
    private final questionRepository RepoQuestion;

    public fackerAnswer(Faker faker, answerRepository Repo_answer, questionRepository RepoQuestion) {
        this.faker = faker;
        this.Repo_answer = Repo_answer;
        this.RepoQuestion = RepoQuestion;
    }

    /*
    @PostConstruct
    public void populateAnswersWithFakerData() {
        List<Answer> answers = new ArrayList();
        List<Question> questions = RepoQuestion.findAll();

        for (Question question : questions) {
            Answer answer = new Answer();
            answer.setAnswerText(faker.lorem().sentence());
            answers.add(answer);
        }
        Repo_answer.saveAll(answers);
    }

     */

}
