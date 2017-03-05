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
public class Patients {

    List<Patient> patients;
    Patient currentPatient;

    public Patients() {
        currentPatient = null;
        getDBPatients();
    }

    public void getDBPatients() {
        try {
            patients = new ArrayList();
            Connection con = Database.getCoonnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM patient_details");
            Patient patient;
            while (rs.next()) {
                patient = new Patient(
                        rs.getString("username"), 
                        rs.getString("patient_id"),
                        rs.getString("name"),
                        rs.getInt("age"));
                patients.add(patient);
            }
             Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, patients.size()+"----------------------------------");
        } catch (SQLException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getPatientReport(String username) {
        for(Patient patient:patients){
            if(patient.getUsername().equalsIgnoreCase(username)){
                currentPatient = patient;
                return "patientReport";
            }
        }     
        return "";
    }
    
    public List<Patient> getPatients() {
        return patients;
    }

    public Patient getCurrentPatient() {
        return currentPatient;
    }

    public void setCurrentPatient(Patient currentPatient) {
        this.currentPatient = currentPatient;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

}
