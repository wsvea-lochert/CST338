/**
 * Title: Project 1
 * Authour: William Svea-Lochert
 * Abstract: This program takes in input data from files and reads the information to create student, course and instructor objects
 *           It also has functions to handle the objects, such as deleting  a course, adding students, and displaying information.
 * Date: 10/07/2018
 **/
package project.project1;

import java.util.ArrayList;

public class Course {
    private int CourseNumber;
    private String courseTitle;
    private int instructorNumber;
    private String classLocation;

    public static ArrayList<Course> courseList = new ArrayList<Course>();

    public Course(int courseNumber, String courseTitle, int instructorNumber, String classLocation) {
        CourseNumber = courseNumber;
        this.courseTitle = courseTitle;
        this.instructorNumber = instructorNumber;
        this.classLocation = classLocation;
        courseList.add(this);
    }

    public int getCourseNumber() {
        return CourseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        CourseNumber = courseNumber;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getInstructorNumber() {
        return instructorNumber;
    }

    public void setInstructorNumber(int instructorNumber) {
        this.instructorNumber = instructorNumber;
    }

    public String getClassLocation() {
        return classLocation;
    }

    public void setClassLocation(String classLocation) {
        this.classLocation = classLocation;
    }

    public void updateLocation(String locationUpdate){
        setClassLocation(locationUpdate);
    }
}

