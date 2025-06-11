package org_skypro.counter_service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org_skypro.counter_service.service.JavaQuestionService;
import org_skypro.counter_service.model.Question;

import java.util.List;

public class JavaQuestionServiceTest {

    @Test
    void getQuestions_ShouldReturnAllQuestions() {
        JavaQuestionService service = new JavaQuestionService();

        List<Question> questions = service.getQuestions();

        assertNotNull(questions);
        assertFalse(questions.isEmpty());
        assertEquals(5, questions.size());
        assertTrue(questions.stream().anyMatch(q -> q.getQuestion().contains("JVM")));
    }

    @Test
    void getRandomQuestion_ShouldReturnRandomQuestion() {
        JavaQuestionService service = new JavaQuestionService();

        for (int i = 0; i < 10; i++) {
            Question q = service.getRandomQuestion();
            assertNotNull(q);
            assertTrue(service.getQuestions().contains(q));
        }
    }

    @Test
    void addQuestion_ShouldAddNewQuestion() {
        JavaQuestionService service = new JavaQuestionService();
        Question newQ = new Question("Что такое JVM?", "Java Virtual Machine");
        boolean added = service.addQuestion(newQ);
        assertTrue(added);
        assertTrue(service.getQuestions().contains(newQ));
    }

    @Test
    void removeQuestion_ShouldRemoveExistingQuestion() {
        JavaQuestionService service = new JavaQuestionService();
        Question q = service.getQuestions().get(0);
        boolean removed = service.removeQuestion(q);
        assertTrue(removed);
        assertFalse(service.getQuestions().contains(q));
    }
}