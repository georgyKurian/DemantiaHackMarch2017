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
public class QuizAttempts {
   List<QuizAttempt> quizAttempts;

    public QuizAttempts() {
        getFromDB();
    }
    
    public void getFromDB(){
         try {
            quizAttempts = new ArrayList();
            Connection con = Database.getCoonnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM quiz_attempt");
            QuizAttempt quizAttempt;
            while (rs.next()) {
                quizAttempt = new QuizAttempt(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getTimestamp("timestamp"));
                quizAttempts.add(quizAttempt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public List<QuizAttempt> getQuizAttemptByUsername(String username){
        List<QuizAttempt> qList = new ArrayList();
        for(QuizAttempt qa:quizAttempts){
            if(qa.getUsername().equals(username)){
                qList.add(qa);
            }
        }
        return qList;
    }
    
}
