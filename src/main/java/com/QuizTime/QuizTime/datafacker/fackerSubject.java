package com.QuizTime.QuizTime.datafacker;

import com.QuizTime.QuizTime.model.entity.Subject;

import com.QuizTime.QuizTime.repository.subjectRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class fackerSubject {

    private final Faker faker;
    private final subjectRepository RepoSubject;

    @Autowired
    public fackerSubject(Faker faker, subjectRepository RepoSubject) {
        this.faker = faker;
        this.RepoSubject = RepoSubject;
    }

    public void populateSubjectData() {
        for (int i = 0; i < 10; i++){
            Subject subject = new Subject();

            subject.setTitle(faker.lorem().word());
            subject.setChildren(generateChildSubjects());

            RepoSubject.save(subject);
        }
    }

    private List<Subject> generateChildSubjects() {
        List<Subject> childSubjects = new ArrayList<>();
        int numChildren = faker.number().numberBetween(1, 5); // Nombre aléatoire d'enfants

        for (int i = 0; i < numChildren; i++) {
            Subject child = new Subject();
            child.setTitle(faker.lorem().word());
            childSubjects.add(child);
        }

        return childSubjects;
    }

}
