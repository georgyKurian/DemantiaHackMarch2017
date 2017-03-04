/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author rkarne
 */
@ManagedBean
@Named
@ApplicationScoped
public class Login {
 
private String username;
private String password;
int userid;
 

/**
* @return the username
*/
public String getUsername() {
return username;
}
 
/**
* @param username the username to set
*/
public void setUsername(String username) {
this.username = username;
}
 
/**
* @return the password
*/
public String getPassword() {
return password;
}

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
 
/**
* @param password the password to set
*/
public void setPassword(String password) {
this.password = password;
}
 
public String login() {
   
    String dbuser ="";
    String dbpass = "";
    PreparedStatement ps = null;
    Connection con = null;
    int id = -1;
    try {
        con= Database.getCoonnection();
        ps = con.prepareStatement("SELECT username, password, user_type FROM login where username=? and password=? ");
       ps.setString(1, username);
       ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            dbuser = rs.getString("username");
            dbpass = rs.getString("password");
            id = rs.getInt("user_type");
        }
       
        
    } catch (SQLException ex) {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
if(username.equals(dbuser) && password.equals(dbpass)){
    if(id == 1){
         return "usersuccess";
    }
    else if(id == 2){
        return "adminsuccess";
    }
}
     return "failure";
}
 
}

