package com.quiz.controller;

import com.quiz.model.Quiz;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping
    public Quiz create(@RequestBody Quiz quiz){
        System.out.println(quiz.getTitle());
        return quizService.add(quiz);
    }

    @GetMapping("/{id}")
    public Quiz get(@PathVariable Long id){
        return quizService.get(id);
    }

    @GetMapping()
    public List<Quiz> getAll(){
        return quizService.get();
    }


}
