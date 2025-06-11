package org_skypro.counter_service.service;

import org.springframework.stereotype.Service;
import org_skypro.counter_service.model.Question;

@Service
public interface QuestionService {
    Question getRandomQuestion();
}