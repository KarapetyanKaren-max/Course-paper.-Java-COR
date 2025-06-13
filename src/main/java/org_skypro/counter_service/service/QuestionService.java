package org_skypro.counter_service.service;

import org_skypro.counter_service.model.Question;
import java.util.List;

/**
 * Интерфейс для работы с вопросами определенного предмета.
 */
public interface QuestionService {

    /**
     * Получить случайный вопрос.
     *
     * @return случайный вопрос
     */
    Question getRandomQuestion();

    /**
     * Получить список всех вопросов.
     *
     * @return список вопросов
     */
    List<Question> getQuestions();

    /**
     * Добавить новый вопрос.
     *
     * @param question вопрос для добавления
     * @return true, если вопрос успешно добавлен, иначе false
     */
    boolean addQuestion(Question question);

    /**
     * Удалить существующий вопрос.
     *
     * @param question вопрос для удаления
     * @return true, если вопрос успешно удален, иначе false
     */
    boolean removeQuestion(Question question);
}