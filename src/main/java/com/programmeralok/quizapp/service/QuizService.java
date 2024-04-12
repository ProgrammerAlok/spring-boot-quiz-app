package com.programmeralok.quizapp.service;

import com.programmeralok.quizapp.dao.QuestionDao;
import com.programmeralok.quizapp.dao.QuizDao;
import com.programmeralok.quizapp.model.Question;
import com.programmeralok.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;
    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, String numQ, String title) {

        List<Question> questions = questionDao.findAllByCategoryIgnoreCase(category);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDao.save(quiz);

        return new ResponseEntity<>("ds", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Question>> getQuestionsByQuizId(int id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        if(quiz.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        List<Question> questions = quiz.get().getQuestions();
        questions = questions
                .stream()
                .map(
                        q -> new Question(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4(), null, null, null)
                )
                .toList();

        System.out.println(questions);

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
}
