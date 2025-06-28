package Day4_ObjectOrientedDesignPrincles.ObjectModeling;

import java.util.ArrayList;

class Company {
    String name;
    ArrayList<Department> departments;

    Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    void addDepartment(String deptName) {
        departments.add(new Department(deptName));
        System.out.println("Department " + deptName + " added to company " + name);
    }

    void addEmployeeToDepartment(String deptName, String empName) {
        for (Department dept : departments) {
            if (dept.deptName.equals(deptName)) {
                dept.addEmployee(empName);
                return;
            }
        }
        System.out.println("Department " + deptName + " not found in " + name);
    }

    void showStructure() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.listEmployees();
        }
        System.out.println();
    }

    void dissolveCompany() {
        departments.clear(); // all departments and employees gone
        System.out.println("Company " + name + " has been dissolved. All departments and employees removed.");
    }

    // Inner class: Department cannot exist without Company
    class Department {
        String deptName;
        ArrayList<Employee> employees;

        Department(String deptName) {
            this.deptName = deptName;
            this.employees = new ArrayList<>();
        }

        void addEmployee(String empName) {
            employees.add(new Employee(empName));
            System.out.println("Employee " + empName + " added to department " + deptName);
        }

        void listEmployees() {
            System.out.println(" Department: " + deptName);
            for (Employee emp : employees) {
                System.out.println("  - " + emp.name);
            }
        }

        // Inner class: Employee cannot exist without Department
        class Employee {
            String name;

            Employee(String name) {
                this.name = name;
            }
        }
    }
}

public class CompositionExample {
    public static void main(String[] args) {
        Company company = new Company("TechNova");

        company.addDepartment("Development");
        company.addDepartment("HR");

        company.addEmployeeToDepartment("Development", "Nishant");
        company.addEmployeeToDepartment("Development", "Rahul");
        company.addEmployeeToDepartment("HR", "Anjali");

        company.showStructure();

        // Now dissolve company
        company.dissolveCompany();
    }
}
