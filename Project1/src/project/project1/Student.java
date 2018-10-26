/**
 * Title: Project 1
 * Authour: William Svea-Lochert
 * Abstract: This program takes in input data from files and reads the information to create student, course and instructor objects
 *           It also has functions to handle the objects, such as deleting  a course, adding students, and displaying information.
 * Date: 10/07/2018
 **/
package project.project1;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Student {
    private int id;
    private String Name;
    private int courseEnrolled;
    private double finalScore;
    private String letterGrade;
    public static ArrayList<Student> studentList = new ArrayList<Student>();

    public Student(int id, String name, int courseEnrolled, double finalScore, String letterGrade) {
        this.id = id;
        this.Name = name;
        this.courseEnrolled = courseEnrolled;
        this.finalScore = finalScore;
        this.letterGrade = letterGrade;
        studentList.add(this);
    }
    public Student(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getCourseEnrolled() {
        return courseEnrolled;
    }

    public void setCourseEnrolled(int courseEnrolled) {
        this.courseEnrolled = courseEnrolled;
    }

    public double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(double finalScore) {
        this.finalScore = finalScore;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    @Override
    public String toString() {
        if (id == -1){
            return "No Student information";
        }
        double studentAvg = 0;
        int enrollCounter = 0;
        System.out.println("Student Number: " + id + "\n" +
                            "Name: " + Name + "\n" +
                            "courseEnrolled: ");
            for (Student s: Student.studentList){
                if (s.getId() == id){
                    studentAvg += s.getFinalScore();
                    enrollCounter++;
                    System.out.println(s.getCourseEnrolled() + ": " + s.getFinalScore() + " (" + s.getLetterGrade() + ")");
                }
            }
        studentAvg = studentAvg/enrollCounter;
        BigDecimal numberBigDecimal = new BigDecimal(studentAvg);
        numberBigDecimal = numberBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        return "Course Average: " + numberBigDecimal;
    }
}
