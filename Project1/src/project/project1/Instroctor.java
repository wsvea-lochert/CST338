/**
 * Title: Project 1
 * Authour: William Svea-Lochert
 * Abstract: This program takes in input data from files and reads the information to create student, course and instructor objects
 *           It also has functions to handle the objects, such as deleting  a course, adding students, and displaying information.
 * Date: 10/07/2018
 **/
package project.project1;

import java.util.ArrayList;

public class Instroctor {
    private int employeeNumber;
    private String name;
    private String email;
    private String phoneNumber;
    public static ArrayList<Instroctor> instroctorList = new ArrayList<Instroctor>();

   // public static HashMap<Integer, Instroctor> instructorMap = new HashMap<Integer, Instroctor>();

    public Instroctor(int employeeNumber, String name, String email, String phoneNumber) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        //adding instructor object to map as value + the employeeNumber as key
        instroctorList.add(this);
        //instructorMap.put(employeeNumber, this);
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
