package com.question.service.impl;

import com.question.entities.Question;
import com.question.repository.QuestionRepository;
import com.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepository.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return questionRepository.findById(id).get();
    }

    @Override
    public List<Question> getQuestionByUserId(Long userId) {
        return questionRepository.findByQuizId(userId);
    }

    // 1:00min
}
