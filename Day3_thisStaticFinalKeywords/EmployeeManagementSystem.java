package Day3_thisStaticFinalKeywords;

public class EmployeeManagementSystem {

    static class Employee {
        // Static variable: shared by all employees
        static String companyName = "Tech Innovators Pvt Ltd";

        // Static variable to track total employees
        static int totalEmployees = 0;

        // Final variable: id should not be modified after assignment
        final int id;
        String name;
        String designation;

        // Constructor using 'this' to resolve ambiguity
        Employee(int id, String name, String designation) {
            this.id = id;
            this.name = name;
            this.designation = designation;
            totalEmployees++; // update static counter
        }

        // Static method to display total number of employees
        static void displayTotalEmployees() {
            System.out.println("Total Employees: " + totalEmployees);
        }

        // Method to display employee details after instanceof check
        void displayDetails() {
            if (this instanceof Employee) {
                System.out.println("Company: " + companyName);
                System.out.println("Employee ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Designation: " + designation);
            }
        }
    }

    public static void main(String[] args) {
        // Create employee objects
        Employee emp1 = new Employee(101, "Alice", "Software Engineer");
        Employee emp2 = new Employee(102, "Bob", "Data Analyst");

        // Display total number of employees
        Employee.displayTotalEmployees();

        // Display individual employee details
        System.out.println("\nEmployee 1 Details:");
        emp1.displayDetails();

        System.out.println("\nEmployee 2 Details:");
        emp2.displayDetails();
    }
}
