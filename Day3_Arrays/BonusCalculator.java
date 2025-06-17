package Day3_Arrays;

import java.util.Scanner;

public class BonusCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int EMPLOYEE_COUNT = 10;

        double[][] employeeData = new double[EMPLOYEE_COUNT][2]; // [][0] = salary, [][1] = years of service
        double[][] results = new double[EMPLOYEE_COUNT][2]; // [][0] = bonus, [][1] = new salary

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        // Step 4: Input salary and years of service
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.println("Enter details for employee #" + (i + 1));

            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            System.out.print("Years of Service: ");
            double years = scanner.nextDouble();

            if (salary <= 0 || years < 0) {
                System.out.println("Invalid input. Please enter positive values.");
                i--; // retry current employee
            } else {
                employeeData[i][0] = salary;
                employeeData[i][1] = years;
            }
        }

        // Step 5: Calculate bonuses and salaries
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            double salary = employeeData[i][0];
            double years = employeeData[i][1];

            double bonusPercentage = (years > 5) ? 0.05 : 0.02;
            double bonus = salary * bonusPercentage;
            double newSalary = salary + bonus;

            results[i][0] = bonus;
            results[i][1] = newSalary;

            totalBonus += bonus;
            totalOldSalary += salary;
            totalNewSalary += newSalary;
        }

        // Step 6: Output results
        System.out.println("\n--- Bonus Report ---");
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.printf("Employee #%d: Old Salary = %.2f, Bonus = %.2f, New Salary = %.2f%n",
                    (i + 1), employeeData[i][0], results[i][0], results[i][1]);
        }

        System.out.println("\nTotal Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
        System.out.println("Total Bonus Payout by Zara: " + totalBonus);

        scanner.close();
    }
}
