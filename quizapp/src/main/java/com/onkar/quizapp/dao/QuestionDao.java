package com.onkar.quizapp.dao;

import com.onkar.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    List<Question> findQuestionByCategory(String category);

    @Query(value = "SELECT * FROM question q Where q.category=category ORDER BY RAND() LIMIT 5", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, int numQ);
}
