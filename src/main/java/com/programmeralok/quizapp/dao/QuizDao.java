package com.programmeralok.quizapp.dao;

import com.programmeralok.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {



}
