package Day4_ObjectOrientedDesignPrincles.ObjectModeling;

import java.util.*;

class Course {
    private String courseName;
    private List<Student> enrolledStudents;

    public Course(String name) {
        this.courseName = name;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void displayEnrolledStudents() {
        System.out.println("Course: " + courseName);
        for (Student student : enrolledStudents) {
            System.out.println(" - " + student.getStudentName());
        }
    }
}

class Student {
    private String studentName;
    private List<Course> enrolledCourses;

    public Student(String name) {
        this.studentName = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getStudentName() {
        return studentName;
    }

    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        course.enrollStudent(this); // bi-directional association
    }

    public void viewEnrolledCourses() {
        System.out.println(studentName + " is enrolled in:");
        for (Course course : enrolledCourses) {
            System.out.println(" - " + course.getCourseName());
        }
    }
}

class School {
    private String schoolName;
    private List<Student> students;

    public School(String name) {
        this.schoolName = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student); // aggregation
    }

    public void displayStudents() {
        System.out.println("Students in " + schoolName + ":");
        for (Student student : students) {
            System.out.println(" - " + student.getStudentName());
        }
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        // Create Courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        // Create Students
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        // Enroll students in courses
        s1.enrollInCourse(math);
        s1.enrollInCourse(science);
        s2.enrollInCourse(science);

        // Create a school and add students (Aggregation)
        School mySchool = new School("Greenwood High");
        mySchool.addStudent(s1);
        mySchool.addStudent(s2);

        // Display
        mySchool.displayStudents();
        System.out.println();
        s1.viewEnrolledCourses();
        s2.viewEnrolledCourses();
        System.out.println();
        math.displayEnrolledStudents();
        science.displayEnrolledStudents();
    }
}
