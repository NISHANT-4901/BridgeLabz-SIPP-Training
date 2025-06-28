package Day4_ObjectOrientedDesignPrincles.ObjectModeling;

import java.util.*;

// Student class
class Student {
    String name;
    int id;
    List<Course> enrolledCourses = new ArrayList<>();

    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void enrollCourse(Course course) {
        enrolledCourses.add(course);
        course.addStudent(this);
        System.out.println(name + " enrolled in " + course.name);
    }
}

// Professor class
class Professor {
    String name;
    String department;

    Professor(String name, String department) {
        this.name = name;
        this.department = department;
    }

    void assignCourse(Course course) {
        course.assignProfessor(this);
        System.out.println(name + " assigned to teach " + course.name);
    }
}

// Course class
class Course {
    String name;
    Professor professor;
    List<Student> students = new ArrayList<>();

    Course(String name) {
        this.name = name;
    }

    void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    void addStudent(Student student) {
        students.add(student);
    }

    void showDetails() {
        System.out.println("Course: " + name);
        if (professor != null) {
            System.out.println("Professor: " + professor.name + " (" + professor.department + ")");
        } else {
            System.out.println("No professor assigned.");
        }
        System.out.println("Enrolled Students:");
        for (Student s : students) {
            System.out.println(" - " + s.name + " (ID: " + s.id + ")");
        }
    }
}

// Main class
public class UniversityStudentManagementII {
    public static void main(String[] args) {
        Student s1 = new Student("Nishant", 101);
        Student s2 = new Student("Aarav", 102);

        Professor p1 = new Professor("Dr. Sharma", "Computer Science");

        Course c1 = new Course("Data Structures");
        Course c2 = new Course("Operating Systems");

        p1.assignCourse(c1);
        s1.enrollCourse(c1);
        s2.enrollCourse(c1);

        s1.enrollCourse(c2); // No professor assigned to c2 yet

        System.out.println();
        c1.showDetails();
        System.out.println();
        c2.showDetails();
    }
}
