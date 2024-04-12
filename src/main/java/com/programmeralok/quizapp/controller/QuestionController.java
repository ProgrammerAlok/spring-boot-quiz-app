package com.programmeralok.quizapp.controller;

import com.programmeralok.quizapp.model.Question;
import com.programmeralok.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("{id}")
    public Question getAllQuestion(@PathVariable int id) {
        return questionService.getQuestionById(id);
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("all")
    public ResponseEntity<List<Question>> getAllQuestion() {
        return questionService.getAllQuestions();
    }

    @PostMapping("create")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }

    @DeleteMapping("{id}")
    public Question deleteQuestion(@PathVariable int id) {
        return questionService.deleteQuestion(id);
    }

}
