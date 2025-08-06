package Day3_JavaStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Employee class implementing Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return String.format("ID: %d, Name: %s, Department: %s, Salary: %.2f",
                id, name, department, salary);
    }
}

public class EmployeeSerialization {
    private static final String FILE_NAME = "employees.ser";

    public static void main(String[] args) {
        // Step 1: Create a list of employees
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101, "Nishant", "IT", 75000));
        employeeList.add(new Employee(102, "Amit", "HR", 60000));
        employeeList.add(new Employee(103, "Priya", "Finance", 65000));

        // Step 2: Serialize the list
        serializeEmployees(employeeList);

        // Step 3: Deserialize the list and display
        List<Employee> deserializedList = deserializeEmployees();
        System.out.println("Deserialized Employee List:");
        for (Employee emp : deserializedList) {
            System.out.println(emp);
        }
    }

    public static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Serialization Error: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Employee> deserializeEmployees() {
        List<Employee> employees = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
        } catch (IOException e) {
            System.out.println("Deserialization IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Error: " + e.getMessage());
        }

        return employees;
    }
}
