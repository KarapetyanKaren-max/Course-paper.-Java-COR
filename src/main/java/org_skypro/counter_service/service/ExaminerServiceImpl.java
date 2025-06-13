package org_skypro.counter_service.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org_skypro.counter_service.model.Question;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int numberOfQuestions) {

        if (questionService instanceof JavaQuestionService) {
            List<Question> allQuestions = ((JavaQuestionService) questionService).getQuestions();
            if (numberOfQuestions > allQuestions.size()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Запрошено больше вопросов, чем есть в сервисе");
            }
        } else {

        }

        Set<Question> questionsSet = new HashSet<>();
        int attempts = 0;
        int maxAttempts = numberOfQuestions * 10;

        while (questionsSet.size() < numberOfQuestions && attempts < maxAttempts) {
            Question q = questionService.getRandomQuestion();
            questionsSet.add(q);
            attempts++;
        }

        if (questionsSet.size() < numberOfQuestions) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Не удалось получить достаточно уникальных вопросов");
        }

        return List.copyOf(questionsSet);
    }
}
