package Day6_EncapPolymorInterAbst;

interface Department {
    void assignDepartment(String deptName);

    String getDepartmentDetails();
}

abstract class Employee {
    private String employeeId;
    private String name;
    private double baseSalary;

    Employee(String employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Base Salary: " + baseSalary);
    }

    abstract double calculateSalary();
}

class FullTimeEmployee extends Employee implements Department {
    private String departmentName;

    FullTimeEmployee(String employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    public void assignDepartment(String deptName) {
        this.departmentName = deptName;
    }

    public String getDepartmentDetails() {
        return "Full-Time Dept: " + departmentName;
    }

    double calculateSalary() {
        return getBaseSalary();
    }
}

class PartTimeEmployee extends Employee implements Department {
    private String departmentName;
    private int hoursWorked;
    private double hourlyRate;

    PartTimeEmployee(String employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public void assignDepartment(String deptName) {
        this.departmentName = deptName;
    }

    public String getDepartmentDetails() {
        return "Part-Time Dept: " + departmentName;
    }

    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee[] employees = new Employee[2];

        FullTimeEmployee fte = new FullTimeEmployee("FT123", "Rohit", 50000);
        fte.assignDepartment("Engineering");

        PartTimeEmployee pte = new PartTimeEmployee("PT456", "Sana", 0, 80, 300);
        pte.assignDepartment("Support");

        employees[0] = fte;
        employees[1] = pte;

        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Calculated Salary: " + emp.calculateSalary());
            if (emp instanceof Department) {
                System.out.println(((Department) emp).getDepartmentDetails());
            }
            System.out.println();
        }
    }
}
