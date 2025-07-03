package Day5_Inheritance;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        System.out.println("Teacher - Name: " + name + ", Age: " + age + ", Subject: " + subject);
    }
}

class Student extends Person {
    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayRole() {
        System.out.println("Student - Name: " + name + ", Age: " + age + ", Grade: " + grade);
    }
}

class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    void displayRole() {
        System.out.println("Staff - Name: " + name + ", Age: " + age + ", Department: " + department);
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        Teacher t = new Teacher("Mr. Sharma", 45, "Mathematics");
        Student s = new Student("Ananya", 16, "10th Grade");
        Staff st = new Staff("Ravi", 35, "Administration");

        t.displayRole();
        s.displayRole();
        st.displayRole();
    }
}
