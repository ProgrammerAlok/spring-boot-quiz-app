package com.programmeralok.quizapp.service;

import com.programmeralok.quizapp.dao.QuestionDao;
import com.programmeralok.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public Question getQuestionById(int id) {
        Optional<Question> q = questionDao.findById(id);
        return q.orElse(null);
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findAllByCategoryIgnoreCase(category);
    }

    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        try {
            return new ResponseEntity<>(questionDao.save(question), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    public Question deleteQuestion(int id) {
        Optional<Question> q = questionDao.findById(id);
        if(q.isPresent()) {
            questionDao.deleteById(id);
        }
        return q.orElse(null);
    }
}
