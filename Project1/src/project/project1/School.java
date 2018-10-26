/**
 * Title: Project 1
 * Authour: William Svea-Lochert
 * Abstract: This program takes in input data from files and reads the information to create student, course and instructor objects
 *           It also has functions to handle the objects, such as deleting  a course, adding students, and displaying information.
 * Date: 10/07/2018
 * */
package project.project1;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class School {
    private String schoolName;
    private int size;
    private int counter = 0;

   // static ArrayList<String> SchoolList = new ArrayList<String>();

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    public String getSchoolName() {
        return schoolName;
    }

    public void readData(String fileName) {
        counter = 0;
        File file = new File(fileName);
        try(BufferedReader in = new BufferedReader(new FileReader(file))){
            String line;
            while((line = in.readLine()) != null){
                if (line.matches("\\d+")){
                    size = Integer.parseInt(line);
                }
                for(int i = 0; i < size; i++){
                    //reads file agien
                    String newLine;
                    newLine = in.readLine();
                    String[] parts = newLine.split(",");
                    //if Counter == 0 we create Instructors
                    if(counter == 0){
                        addInstructor(Integer.valueOf(parts[0]), parts[1], parts[2], parts[3]);
                    }
                    //counter == 1 we create Courses
                    else if(counter == 1){
                        addCourse(Integer.valueOf(parts[0]), parts[1], Integer.valueOf(parts[2]), parts[3]);
                    }
                    // if counter == 2 we create students
                    else if(counter == 2){
                        addStudent(Integer.valueOf(parts[0]), parts[1], Integer.valueOf(parts[2]), Double.valueOf(parts[3]), parts[4]);
                    }
                }
                counter++;
            }
            System.out.println("Done.");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            alert(e);
            return;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void alert(IOException melding) {
        System.out.println("Something went wrong, file was not found");
    }
    //adds a student
    public boolean addStudent(int id, String name, int courseEnrolled, double finalScore, String letterGrade){
        boolean controller = false;
        for (Course course : Course.courseList){
            if (courseEnrolled != course.getCourseNumber()){
                controller = false;
            }
            else if(courseEnrolled == course.getCourseNumber()){
                controller = true;
                break;
            }
        }
        if (controller == false){
            System.out.println("Student info addition failed – Non-existing course number.");
        }
        else if(controller == true){
            if(Student.studentList.size() == 0){
                Student tempStudent = new Student(id, name, courseEnrolled, finalScore, letterGrade);
                return true;
            }
            else if(!Student.studentList.isEmpty()){
                boolean nameTest = true;
                for (Student student: Student.studentList){
                    if (id == student.getId()) {
                        if (student.getName().equals(name)){
                            if (student.getCourseEnrolled() == courseEnrolled){
                                System.out.println("Student is already added to this course");
                                return false;
                            }
                            nameTest = true;
                            break;
                        }
                        else if (!student.getName().equals(name)){
                            nameTest = false;
                        }
                    }
                }
                if (nameTest){
                    Student tempStudent = new Student(id, name, courseEnrolled, finalScore, letterGrade);
                    return true;
                }
                else if (!nameTest){
                    System.out.println("Student info addition failed – Student ID number already used.");
                    return false;
                }
            }
        }
        return false;
    }
    //adds a Instructor
    public boolean addInstructor(int employeeNumber, String name, String email, String phoneNumber){
        if (Instroctor.instroctorList.size() == 0){
            Instroctor tempInstructor = new Instroctor(employeeNumber, name, email, phoneNumber);
            return true;
        }
        for(Instroctor i : Instroctor.instroctorList){
            if(i.getEmployeeNumber() == employeeNumber){
                System.out.println("Instructor addition failed – Employee number already used.");
                return false;
            }
        }
        Instroctor tempInstructor = new Instroctor(employeeNumber, name, email, phoneNumber);
        return true;
    }
    //Adds a course
    public boolean addCourse(int courseNumber, String courseTitle, int instructorNumber, String classLocation){
        boolean check = true;
        if(Course.courseList.size() == 0){
            Course tempCourse = new Course(courseNumber, courseTitle, instructorNumber, classLocation);
            return false;
        }
        for (Course c: Course.courseList){
            if (c.getCourseNumber() == courseNumber){
                System.out.println("Course addition failed – Course number already used.");
                return false;
            }
            for (Instroctor i: Instroctor.instroctorList){
                if (instructorNumber != i.getEmployeeNumber()){
                    check = false;
                }
                else if(instructorNumber == i.getEmployeeNumber()){
                    check = true;
                    break;
                }
            }
        }
        if (check){
            Course tempCourse = new Course(courseNumber, courseTitle, instructorNumber, classLocation);
            return true;
        }
        else if (!check){
            System.out.println("Course addition failed – Non-existing instructor.");
            return false;
        }
        return false;
    }
    //print school information
    public void schoolInfo(){
        System.out.println("School name: " + schoolName);
        System.out.println("Instructor information");
        for (Instroctor i: Instroctor.instroctorList){
            System.out.println(i.getName());
        }
        System.out.println("Course Information");
        for (Course c: Course.courseList){
            System.out.println(c.getCourseTitle());
        }
        System.out.println("Student Information");
            printStudent();
    }
    //prints student name + their enrolled course title.
    public void printStudent(){
        for (Student s: Student.studentList){
            for (Course c: Course.courseList){
                if(s.getCourseEnrolled() == c.getCourseNumber()){
                    System.out.println(s.getName() + ": " + c.getCourseTitle());
                }
            }
        }
    }
    // gets courseInfo
    public void courseInfo(int courseNumber){
        int enrollCounter = 0;
        double courseAvg = 0.0;
        boolean controller = true;
        for (Course c: Course.courseList){
            if (c.getCourseNumber() == courseNumber){
                System.out.println("Course Number: " + c.getCourseNumber());
                for (Instroctor i: Instroctor.instroctorList){
                    if (i.getEmployeeNumber() == c.getInstructorNumber() && c.getCourseNumber() == courseNumber){
                        System.out.println("Instructor:" + i.getName());
                    }
                }
                System.out.println("Course Title: " + c.getCourseTitle());
                System.out.println("Room: " + c.getClassLocation());

                for(Student s: Student.studentList){
                    if (s.getCourseEnrolled() == courseNumber){
                        enrollCounter++;
                        courseAvg += s.getFinalScore();
                    }
                }
                double avg = courseAvg/enrollCounter;
                System.out.println("Total Enrolled: " + enrollCounter);
                BigDecimal numberBigDecimal = new BigDecimal(avg);
                numberBigDecimal = numberBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
                System.out.println("Course Average: " + numberBigDecimal);

                controller = true;
                break;
            }
            else{
                controller = false;
            }
        }
        if (!controller){
            System.out.println("The course was not fount");
        }
    }
    //Overloaded courseInfo method
    public void courseInfo(){
        int enrollCounter = 0;
        System.out.println("Number of Courses: " + Course.courseList.size());
        for (Course c: Course.courseList){
            enrollCounter = 0;
                for(Student s: Student.studentList){
                        if (c.getCourseNumber() == s.getCourseEnrolled()){
                            enrollCounter++;
                        }
                }
                System.out.println(c.getCourseNumber() + ": " + enrollCounter + " enrolled");
        }

    }
    //gets course and returns the course with courseNumber
    public Course getCourse(int courseNumber){
        boolean controller = false;
        for (Course c: Course.courseList){
            if (c.getCourseNumber() == courseNumber){
                controller = true;
                return c;
            }
        }
        if (!controller){
            System.out.println("The course you are looking for is not in the system.");
        }
        return null;
    }

    public boolean deleteCourse(int courseNumber){
        boolean controller = false;

        for (Student s: Student.studentList){
            if (s.getCourseEnrolled() == courseNumber){
                System.out.println("Course deletion failed – Enrolled student(s) in the class");
                return false;
            }
            else{
                controller = true;
            }
        }

        if (controller){
            for (Course c: Course.courseList){
                if (c.getCourseNumber() == courseNumber){
                    Course.courseList.remove(c);
                    return true;
                }
            }
        }
        return false;
    }

    public Student getStudentInfo(int id){
        boolean controller = false;
        for (Student s: Student.studentList){
            if (s.getId() == id){
                return s;
            }
        }
        if (!controller){
            System.out.println("Student Number: " + id);
            Student blank = new Student(-1);
            return blank;
        }
        return null;
    }

    public boolean graduateStudent(int id) {
        boolean controller = false;
        ArrayList<Student> graduatingStudent = new ArrayList<Student>();

        for (Student s : Student.studentList){
            if (s.getId() == id){
                graduatingStudent.add(s);
                controller = true;
            }
        }
        if (!controller){
            System.out.println("Student graduation failed – Non-existing student.");
            return controller;
        }
        else{
            Student.studentList.removeAll(graduatingStudent);
            graduatingStudent = null;
            return controller;
        }
    }
}



