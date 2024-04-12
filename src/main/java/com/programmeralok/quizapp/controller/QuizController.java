package com.programmeralok.quizapp.controller;

import com.programmeralok.quizapp.model.Question;
import com.programmeralok.quizapp.model.Quiz;
import com.programmeralok.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(
            @RequestParam String category,
            @RequestParam String numberOfQuestion,
            @RequestParam String title
    ) {
        return quizService.createQuiz(category, numberOfQuestion, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<Question>> getQuestionsByQuizId(@PathVariable int id) {
        return quizService.getQuestionsByQuizId(id);
    }

}
