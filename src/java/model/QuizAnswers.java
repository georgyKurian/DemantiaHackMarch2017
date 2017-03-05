/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Georgi
 */
@Named
@ApplicationScoped
public class QuizAnswers {

    List<QuizAnswer> quizAnswers;

    public QuizAnswers() {
        getFromDB();
    }

    public void getFromDB() {
        try {
            quizAnswers = new ArrayList();
            Connection con = Database.getCoonnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM quiz_answer");
            QuizAnswer quizAnswer;
            while (rs.next()) {
                quizAnswer = new QuizAnswer(
                        rs.getInt("id"),
                        rs.getInt("question_no"),
                        rs.getInt("score"));
                quizAnswers.add(quizAnswer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public double getScoreByQuizId(int id){
        int total = 0;
        int score = 0;
        for (QuizAnswer q : quizAnswers) {
           if(q.getQuestion_no()==id){
               score = score +q.getScore();
               total ++;
           }
        }
        double percentage = 0;
        if(total != 0)
             percentage = (score/total) * 100;
        return percentage;
    }

}
