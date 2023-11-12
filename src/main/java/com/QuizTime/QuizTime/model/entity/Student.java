package com.QuizTime.QuizTime.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToMany(mappedBy = "student",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AssignQuiz> assignQuiz;


}
