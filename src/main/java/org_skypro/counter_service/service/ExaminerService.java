package org_skypro.counter_service.service;

import org.springframework.stereotype.Service;
import org_skypro.counter_service.model.Question;
import java.util.List;

@Service
public interface ExaminerService {
    List<Question> getQuestions(int numberOfQuestions);
}