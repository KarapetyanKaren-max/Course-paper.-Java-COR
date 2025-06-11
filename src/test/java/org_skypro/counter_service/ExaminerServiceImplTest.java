package org_skypro.counter_service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org_skypro.counter_service.service.ExaminerServiceImpl;
import org_skypro.counter_service.service.QuestionService;
import org_skypro.counter_service.model.Question;

import java.util.Arrays;
import java.util.List;

public class ExaminerServiceImplTest {

    @Test
    void getQuestions_ShouldReturnRequestedNumberOfUniqueQuestions() {

        Question q1 = new Question("Q1", "A1");
        Question q2 = new Question("Q2", "A2");

        QuestionService mockService = mock(QuestionService.class);

        when(mockService.getRandomQuestion())
                .thenReturn(q1)
                .thenReturn(q2)
                .thenReturn(q1)
                .thenReturn(q2);

        ExaminerServiceImpl examiner = new ExaminerServiceImpl(mockService);

        List<Question> questions = examiner.getQuestions(2);

        assertNotNull(questions);
        assertEquals(2, questions.size());

        assertTrue(questions.contains(q1));
        assertTrue(questions.contains(q2));

        verify(mockService, atLeast(2)).getRandomQuestion();
    }

    @Test
    void getQuestions_ShouldThrowExceptionIfNotEnoughUniqueQuestions() {

        Question q1 = new Question("Q1", "A1");

        QuestionService mockService = mock(QuestionService.class);

        when(mockService.getRandomQuestion()).thenReturn(q1);

        ExaminerServiceImpl examiner = new ExaminerServiceImpl(mockService);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            examiner.getQuestions(3);
        });


        verify(mockService, atLeast(3)).getRandomQuestion();
    }
}
