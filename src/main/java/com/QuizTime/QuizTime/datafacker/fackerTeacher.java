package com.QuizTime.QuizTime.datafacker;

import com.QuizTime.QuizTime.model.entity.Teacher;
import com.QuizTime.QuizTime.repository.teacherRepository;
import net.datafaker.Faker;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;


@Component
public class fackerTeacher {

    private final Faker faker;
    private final teacherRepository Repoteacher;

    public fackerTeacher(Faker faker, teacherRepository repoteacher) {
        this.faker = faker;
        Repoteacher = repoteacher;
    }

    public void populateTeachersWithFackerData(int numbersOfRecords){
        List<Teacher> teachers = new ArrayList<>();

        for(int i = 0; i < numbersOfRecords; i++){
            Teacher teacher = new Teacher();

            teacher.setFirstName(faker.name().firstName());
            teacher.setLastName(faker.name().lastName());
            teacher.setDateOfBirth(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            teacher.setAddress(faker.address().fullAddress());
            teacher.setSpeciality(faker.company().profession());

            teachers.add(teacher);
        }
        Repoteacher.saveAll(teachers);
    }


}
