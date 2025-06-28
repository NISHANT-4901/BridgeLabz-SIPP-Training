package Day4_ObjectOrientedDesignPrincles.ObjectModeling;

import java.util.ArrayList;
import java.util.List;

// Faculty class: Aggregation (can exist independently)
class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Faculty: " + name);
    }
}

// Employee inside Department: Optional if more detail needed
class Employee {
    String empName;

    Employee(String name) {
        this.empName = name;
    }

    void display() {
        System.out.println("Employee: " + empName);
    }
}

// Department class: Composed by University
class Department {
    String deptName;
    List<Employee> employees = new ArrayList<>();

    Department(String name) {
        this.deptName = name;
    }

    void addEmployee(Employee emp) {
        employees.add(emp);
    }

    void display() {
        System.out.println("Department: " + deptName);
        for (Employee e : employees) {
            e.display();
        }
    }
}

// University class: Composes Departments, Aggregates Faculties
class University {
    String name;
    List<Department> departments = new ArrayList<>();
    List<Faculty> faculties = new ArrayList<>();

    University(String name) {
        this.name = name;
    }

    void addDepartment(Department dept) {
        departments.add(dept);
    }

    void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    void display() {
        System.out.println("University: " + name);
        System.out.println("Departments:");
        for (Department d : departments) {
            d.display();
        }
        System.out.println("Faculties:");
        for (Faculty f : faculties) {
            f.display();
        }
    }

    void destroy() {
        departments.clear(); // Composition: remove departments
        // Faculty are NOT removed - aggregation
        System.out.println("University " + name + " deleted with all departments.");
    }
}

// Driver class
public class UniversityStudentManagement {
    public static void main(String[] args) {
        // Faculties can exist independently
        Faculty f1 = new Faculty("Dr. Sharma");
        Faculty f2 = new Faculty("Prof. Mehta");

        University uni = new University("Global Tech University");

        Department cs = new Department("Computer Science");
        cs.addEmployee(new Employee("Alice"));
        cs.addEmployee(new Employee("Bob"));

        Department ee = new Department("Electrical Engineering");
        ee.addEmployee(new Employee("Charlie"));

        uni.addDepartment(cs);
        uni.addDepartment(ee);

        uni.addFaculty(f1);
        uni.addFaculty(f2);

        System.out.println("=== BEFORE DELETION ===");
        uni.display();

        System.out.println("\n=== AFTER DELETION OF UNIVERSITY ===");
        uni.destroy(); // Departments deleted
        f1.display(); // Faculty still exists
        f2.display();
    }
}
