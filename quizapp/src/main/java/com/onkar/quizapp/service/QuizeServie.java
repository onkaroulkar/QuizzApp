package com.onkar.quizapp.service;
import com.onkar.quizapp.dao.QuestionDao;
import com.onkar.quizapp.dao.QuizeDao;
import com.onkar.quizapp.model.Question;
import com.onkar.quizapp.model.Quize;
import com.onkar.quizapp.model.QusetionWrapper;
import com.onkar.quizapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuizeServie {

    @Autowired
    QuizeDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuize(String category, int numQ, String title) {

        List<Question> questions = questionDao.findRandomQuestionByCategory(category,numQ);
        Quize quize = new Quize();
        quize.setTitle(title);
        quize.setQuestions(questions);
        quizDao.save(quize);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    public ResponseEntity<List<QusetionWrapper>> getQuizQuestions(Integer id) {
        Quize quize = quizDao.getReferenceById(id);
        List<Question> questionsFromDB = quize.getQuestions();
        List<QusetionWrapper> quetionsForUsers = new ArrayList<>();
        for(Question q : questionsFromDB){
            QusetionWrapper qw = new QusetionWrapper(q.getId(),q.getQuestion_title(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            quetionsForUsers.add(qw);
        }
        return new ResponseEntity<>(quetionsForUsers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quize quize = quizDao.getReferenceById(id);
        List<Question> questions = quize.getQuestions();
        int right =0;
        int i=0;
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getRightAns())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
