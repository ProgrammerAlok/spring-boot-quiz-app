package com.programmeralok.quizapp.dao;

import com.programmeralok.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findAllByCategoryIgnoreCase(String category);

}
