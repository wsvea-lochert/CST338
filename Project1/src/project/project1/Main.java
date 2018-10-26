/**
 * Title: Project 1
 * Authour: William Svea-Lochert
 * Abstract: This program takes in input data from files and reads the information to create student, course and instructor objects
 *           It also has functions to handle the objects, such as deleting  a course, adding students, and displaying information.
 * Date: 10/07/2018
 **/
package project.project1;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        School SCD = new School("SCD");
        Course course1;
        Student student1;
        System.out.println("===== Read Data 1 =====");
        SCD.readData("/Users/william/Documents/Project1/src/project/project1/test1.txt");
        System.out.println("\n===== School Info 1 =====");
        SCD.schoolInfo();
        System.out.println("===== Read Data 2 =====");
        SCD.readData("/Users/william/Documents/Project1/src/project/project1/test2.txt");
       System.out.println("\n===== School Info 2 =====");
        SCD.schoolInfo();
        SCD.addInstructor(700, "E. Tao", "tao@csumb.edu", "777-777-1234");
        SCD.addCourse(300, "CST300 – ProSem", 700, "BIT110");
        SCD.addCourse(231, "CST231 – Intro C++", 100, "BIT104");
        System.out.println("\n===== Failed Course Addition =====");
        SCD.addCourse(306, "CST306 – GUI Dev", 250, "BIT120");
        SCD.addCourse(499, "CST499 – iOS Dev", 150, "BIT104");
        System.out.println("\n===== Detailed Course Info =====");
        SCD.courseInfo(306);
        course1 = SCD.getCourse(205);
        course1.updateLocation("Library 104");
        System.out.println("\n===== Detailed Course Info 2 =====");
        SCD.courseInfo(205);
        System.out.println("\n===== Detailed Course Info 3 =====");
        SCD.courseInfo();
        SCD.deleteCourse(231);
        SCD.deleteCourse(336);
        SCD.deleteCourse(338);
        System.out.println("\n===== Detailed Course Info 4 =====");
        SCD.courseInfo();
        SCD.addStudent(5555, "Chris Watson", 205, 85.50, "B");
        System.out.println("\n===== Detailed Course Info 5 =====");
        SCD.courseInfo(205);
        student1 = SCD.getStudentInfo(7777);
        System.out.println("\n===== Detailed Student Info =====");
        System.out.println(student1);
        SCD.graduateStudent(7777);
        System.out.println("\n===== Detailed Student Info 2 =====");
        System.out.println(SCD.getStudentInfo(7777));
        SCD.graduateStudent(5555);
        System.out.println("\n===== Detailed Course Info 6 =====");
        SCD.courseInfo(205);
        SCD.graduateStudent(5555);
        System.out.println("\n===== Good Job! Bye! =====");

    }
}
