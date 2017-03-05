/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.servlet.annotation.WebServlet;

/**
 *
 * @author rkarne
 */

public class Question {
    private int id;
    private String question;
    private int correct_answer;
    
    Question(int id, String question, int correct){
        this.id=id;
        this.question=question;
        this.correct_answer=correct;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public int getCorrect_answer() {
        return correct_answer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrect_answer(int correct_answer) {
        this.correct_answer = correct_answer;
    }
    
}
