package Day2_JavaConstructor;

public class EmployeeRecords {

    // Parent class
    static class Employee {
        public int employeeID; // Public: accessible everywhere
        protected String department; // Protected: accessible in same package or subclass
        private double salary; // Private: accessible only within this class

        // Constructor
        public Employee(int employeeID, String department, double salary) {
            this.employeeID = employeeID;
            this.department = department;
            this.salary = salary;
        }

        // Public method to set (modify) salary
        public void setSalary(double salary) {
            if (salary >= 0) {
                this.salary = salary;
            } else {
                System.out.println("Invalid salary amount.");
            }
        }

        // Public method to get salary
        public double getSalary() {
            return this.salary;
        }

        // Display method
        public void displayEmployeeInfo() {
            System.out.println("Employee ID: " + employeeID);
            System.out.println("Department: " + department);
            System.out.println("Salary: " + salary);
        }
    }

    // Subclass
    static class Manager extends Employee {

        // Constructor
        public Manager(int employeeID, String department, double salary) {
            super(employeeID, department, salary);
        }

        // Method to show Manager details using access to inherited fields
        public void showManagerDetails() {
            System.out.println("Manager ID: " + employeeID); // public access
            System.out.println("Manager Department: " + department); // protected access
            // Cannot access salary directly (private), so use method:
            System.out.println("Manager Salary: " + getSalary());
        }
    }

    // Main method
    public static void main(String[] args) {
        // Create an Employee
        Employee emp = new Employee(101, "HR", 50000);
        emp.displayEmployeeInfo();

        System.out.println("\nUpdating salary...");
        emp.setSalary(55000);
        System.out.println("Updated Salary: " + emp.getSalary());

        System.out.println("\nCreating a Manager...");
        Manager mgr = new Manager(201, "IT", 80000);
        mgr.showManagerDetails();

        System.out.println("\nUpdating Manager salary...");
        mgr.setSalary(85000);
        System.out.println("Updated Manager Salary: " + mgr.getSalary());
    }
}
