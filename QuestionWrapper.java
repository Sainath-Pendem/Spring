package com.example.quiz.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class QuestionWrapper {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    String c1;
    String c2;
    String c3;
    String c4;
    String question;

    public QuestionWrapper(Integer id, String c1, String c2, String c3, String c4, String question) {
        id = id;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.question = question;
    }
}
