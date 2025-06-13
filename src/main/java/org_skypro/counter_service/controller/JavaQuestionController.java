package org_skypro.counter_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org_skypro.counter_service.model.Question;
import org_skypro.counter_service.service.JavaQuestionService;
import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final JavaQuestionService questionService;

    @Autowired
    public JavaQuestionController(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/add")
    public String addQuestion(@RequestParam String question, @RequestParam String answer) {
        if (question == null || answer == null || question.isEmpty() || answer.isEmpty()) {
            return "Вопрос и ответ не могут быть пустыми.";
        }
        boolean added = questionService.addQuestion(new Question(question, answer));
        return added ? "Вопрос добавлен." : "Не удалось добавить вопрос.";
    }

    @DeleteMapping("/remove")
    public String removeQuestion(@RequestParam String question, @RequestParam String answer) {
        if (question == null || answer == null || question.isEmpty() || answer.isEmpty()) {
            return "Вопрос и ответ не могут быть пустыми.";
        }
        boolean removed = questionService.removeQuestion(new Question(question, answer));
        return removed ? "Вопрос удален." : "Вопрос не найден.";
    }

    @GetMapping("/all")
    public List<Question> getAllQuestions() {
        return ((JavaQuestionService)questionService).getQuestions();
    }
}