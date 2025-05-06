package com.onkar.quizapp.service;
import com.onkar.quizapp.dao.QuestionDao;
import com.onkar.quizapp.dao.QuizeDao;
import com.onkar.quizapp.model.Question;
import com.onkar.quizapp.model.Quize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuizeServie {

    @Autowired
    QuizeDao quizeDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuize(String category, int numQ, String title) {

        List<Question> questions = questionDao.findRandomQuestionByCategory(category,numQ);
        Quize quize = new Quize();
        quize.setTitle(title);
        quize.setQuestions(questions);
        quizeDao.save(quize);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }
}
