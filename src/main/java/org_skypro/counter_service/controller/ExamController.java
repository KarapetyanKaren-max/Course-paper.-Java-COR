package org_skypro.counter_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org_skypro.counter_service.model.Question;
import org_skypro.counter_service.service.ExaminerService;

import java.util.List;

@RestController
public class ExamController {

    private final ExaminerService examinerService;
    @Autowired
    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/questions")
    public List<Question> getQuestions(@RequestParam int amount) {
        return examinerService.getQuestions(amount);
    }
}
