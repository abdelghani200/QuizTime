package com.QuizTime.QuizTime.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "students")
public class Student extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDate registrationDate;

    @OneToMany(mappedBy = "student")
    private List<AssignQuiz> assignQuiz;

    /*
    @Version
    private Integer version;
     */
}
