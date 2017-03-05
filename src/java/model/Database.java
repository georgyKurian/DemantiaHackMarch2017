/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author rkarne
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rkarne
 */
public class Database {

    public static java.sql.Connection getCoonnection() throws SQLException {

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);

            return null;

        }

//        String hostname = "sql9.freemysqlhosting.net";
//        String port = "3306";
//        String dbname = "sql9162100";
//        String username = "sql9162100";
//        String password = "Pv2cUljhTZ";
//        String jdbc = String.format("jdbc:mysql://%s:%s/%s", hostname, port, dbname);
        
        String hostname = "localhost";
        String port = "3306";
        String dbname = "demantia";
        String username = "demantia";
        String password = "demantia";
        String jdbc = String.format("jdbc:mysql://%s:%s/%s", hostname, port, dbname);
        
        return DriverManager.getConnection(jdbc, username, password);

    }

}
