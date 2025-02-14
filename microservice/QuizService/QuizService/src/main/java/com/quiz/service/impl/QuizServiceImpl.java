package com.quiz.service.impl;

import com.quiz.model.Quiz;
import com.quiz.repository.QuizRepository;
import com.quiz.service.QuestionClient;
import com.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    private final QuestionClient questionClient;
    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes =  quizRepository.findAll();

        List<Quiz> newQuizList= quizzes.stream().map(quiz ->{
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz = quizRepository.findById(id).get();
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }
}
