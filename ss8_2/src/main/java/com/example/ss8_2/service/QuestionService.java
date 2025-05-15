package com.example.ss8_2.service;

import com.example.ss8_2.Model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionService {
    private List<Question> questions = new ArrayList<>();

    public QuestionService() {
        questions.add(new Question(1, "https://i.pinimg.com/736x/a2/bd/7f/a2bd7f89ace1461c065359b7f02d4b92.jpg", "Answer1"));
        questions.add(new Question(2, "https://i.pinimg.com/736x/a2/bd/7f/a2bd7f89ace1461c065359b7f02d4b92.jpg", "Answer2"));
        questions.add(new Question(3, "https://i.pinimg.com/736x/a2/bd/7f/a2bd7f89ace1461c065359b7f02d4b92.jpg", "Answer3"));
    }

    public Question getRandomQuestion() {
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }
}

