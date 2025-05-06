package com.onkar.quizapp.dao;

import com.onkar.quizapp.model.Quize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizeDao extends JpaRepository<Quize,Integer> {

}
