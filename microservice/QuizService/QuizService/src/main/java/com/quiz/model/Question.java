package com.quiz.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class Question {
    private Long questionId;
    private String question;
    private Long quizId;
}
