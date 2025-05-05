package com.onkar.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String question_title;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAns;
    private String difficultylevel;
    private String category;

    public Question() {

    }

    public Question(Integer id, String question_title, String option1, String option2, String option3, String option4, String rightAns, String difficultylevel, String category) {
        this.id = id;
        this.question_title = question_title;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.rightAns = rightAns;
        this.difficultylevel = difficultylevel;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public String getQuestion_title() {
        return question_title;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getRightAns() {
        return rightAns;
    }

    public String getDifficultylevel() {
        return difficultylevel;
    }

    public String getCategory() {
        return category;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuestion_title(String question_title) {
        this.question_title = question_title;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public void setRightAns(String rightAns) {
        this.rightAns = rightAns;
    }

    public void setDifficultylevel(String difficultylevel) {
        this.difficultylevel = difficultylevel;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question_title='" + question_title + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", rightAns='" + rightAns + '\'' +
                ", difficultylevel='" + difficultylevel + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
