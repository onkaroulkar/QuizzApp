package com.onkar.quizapp.service;

import com.onkar.quizapp.dao.QuestionDao;
import com.onkar.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {

        return questionDao.findAll();
    }

    public List<Question> findQuestionByCategory(String category){
        return questionDao.findQuestionByCategory(category);
    }

    public String addQuestion(Question question){
        questionDao.save(question);
        return "success";
    }
}
