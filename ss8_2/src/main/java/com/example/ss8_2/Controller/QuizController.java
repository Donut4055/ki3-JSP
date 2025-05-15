package com.example.ss8_2.Controller;

import com.example.ss8_2.Model.Question;
import com.example.ss8_2.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class QuizController {

    private QuestionService questionService = new QuestionService();
    private Map<String, Integer> attempts = new HashMap<>();

    @GetMapping("/quiz")
    public String showQuiz(Model model) {
        Question question = questionService.getRandomQuestion();
        model.addAttribute("question", question);
        model.addAttribute("message", "");
        model.addAttribute("attempts", 0);
        return "quiz";
    }

    @PostMapping("/guess")
    public String guessAnswer(@RequestParam String answer, @RequestParam int questionId, Model model) {
        Question question = questionService.getRandomQuestion();
        String userId = "user";

        int attemptCount = attempts.getOrDefault(userId, 0);
        if (attemptCount >= 3) {
            model.addAttribute("message", "Bạn hết lượt đoán!");
            return "quiz";
        }

        if (answer.equalsIgnoreCase(question.getAnswer())) {
            model.addAttribute("message", "Đã đoán đúng!");
            return "quiz";
        } else {
            attempts.put(userId, attemptCount + 1);
            model.addAttribute("message", "Đoán sai, thử lại!");
            model.addAttribute("question", question);
            model.addAttribute("attempts", attemptCount + 1);
            return "quiz";
        }
    }
}
