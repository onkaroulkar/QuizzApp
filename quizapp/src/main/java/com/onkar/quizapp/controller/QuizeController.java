package com.onkar.quizapp.controller;

import com.onkar.quizapp.model.QusetionWrapper;
import com.onkar.quizapp.service.QuizeServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizeController  {

    @Autowired
    QuizeServie quizServie;

    @PostMapping("create")
    public ResponseEntity<String> createQuize(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
            return quizServie.createQuize(category,numQ,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QusetionWrapper>> getQuizeQuestion(@PathVariable Integer id){
            return quizServie.getQuizQuestions(id);
    }
}
