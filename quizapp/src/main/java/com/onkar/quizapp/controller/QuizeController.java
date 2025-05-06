package com.onkar.quizapp.controller;

import com.onkar.quizapp.service.QuizeServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
public class QuizeController  {

    @Autowired
    QuizeServie quizeServie;

    @PostMapping("create")
    public ResponseEntity<String> createQuize(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
            return quizeServie.createQuize(category,numQ,title);
    }
}
