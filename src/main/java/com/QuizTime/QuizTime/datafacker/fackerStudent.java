package com.QuizTime.QuizTime.datafacker;

import com.QuizTime.QuizTime.model.entity.Student;
import com.QuizTime.QuizTime.repository.studentRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Component
public class fackerStudent {

    private final Faker faker;
    private final studentRepository Repostudent;

    @Autowired
    public fackerStudent(Faker faker, studentRepository Repostudent){
        this.faker = faker;
        this.Repostudent = Repostudent;
    }

    public void populateStudentsWithFackerData(int numberOfRecords) {
        List<Student> students = new ArrayList<>();

        for(int i = 0 ; i < numberOfRecords; i++){
            Student student = new Student();

            student.setFirstName(faker.name().firstName());
            student.setLastName(faker.name().lastName());
            student.setDateOfBirth(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            student.setAddress(faker.address().fullAddress());
            student.setRegistrationDate(LocalDate.now());

            students.add(student);
        }

        Repostudent.saveAll(students);
    }

}
