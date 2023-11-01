package com.QuizTime.QuizTime.datafacker;


import com.QuizTime.QuizTime.enums.TypeAnswer;
import com.QuizTime.QuizTime.model.entity.Question;
import com.QuizTime.QuizTime.repository.questionRepository;
import net.datafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class fakerQuestion {

    private final Faker faker;
    private final questionRepository Repo_question;

    public fakerQuestion(Faker faker, questionRepository Repo_question) {
        this.faker = faker;
        this.Repo_question = Repo_question;
    }

    public void populateQuestionsWithFakerData(int numberOfRecords) {
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < numberOfRecords; i++) {
            Question question = new Question();

            question.setAnswerNumber(faker.number().numberBetween(1, 5));
            question.setAnswerCorrectNumber(faker.number().numberBetween(1, 3));
            question.setText(faker.lorem().sentence());
            question.setType(TypeAnswer.values()[faker.number().numberBetween(0, TypeAnswer.values().length)]);
            question.setScorePoints(faker.number().randomDouble(2, 0, 10));

            questions.add(question);
        }

        Repo_question.saveAll(questions);
    }


}
