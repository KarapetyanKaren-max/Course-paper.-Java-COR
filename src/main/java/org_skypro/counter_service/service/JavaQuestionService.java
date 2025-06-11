package org_skypro.counter_service.service;

import org.springframework.stereotype.Service;
import org_skypro.counter_service.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {

    private final List<Question> questions = new ArrayList<>();
    private final Random random = new Random();

    public JavaQuestionService() {

        questions.add(new Question("Что такое JVM?", "Java Virtual Machine"));
        questions.add(new Question("Что такое JDK?", "Java Development Kit"));
        questions.add(new Question("Что такое JRE?", "Java Runtime Environment"));
        questions.add(new Question("Что такое garbage collector?", "Автоматическая сборка мусора"));
        questions.add(new Question("Что такое интерфейс?", "Абстрактный тип данных"));

    }

    @Override
    public Question getRandomQuestion() {
        int index = random.nextInt(questions.size());
        return questions.get(index);
    }

    public List<Question> getQuestions() {
        return new ArrayList<>(questions);
    }

    public boolean addQuestion(Question question) {
        return questions.add(question);
    }

    public boolean removeQuestion(Question question) {
        return questions.remove(question);
    }
}
