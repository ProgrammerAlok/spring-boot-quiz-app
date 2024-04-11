package com.programmeralok.quizapp.controller;

import com.programmeralok.quizapp.model.Question;
import com.programmeralok.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("all")
    public List<Question> getAllQuestion() {
        return questionService.getAllQuestions();
    }

}
