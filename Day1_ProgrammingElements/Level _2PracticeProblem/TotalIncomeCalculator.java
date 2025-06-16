package Day1_ProgrammingElements;

import java.util.Scanner;

public class TotalIncomeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take salary input
        System.out.print("Enter salary (INR): ");
        double salary = sc.nextDouble();

        // Step 2: Take bonus input
        System.out.print("Enter bonus (INR): ");
        double bonus = sc.nextDouble();

        // Step 3: Calculate total income
        double totalIncome = salary + bonus;

        // Step 4: Print the result
        System.out.println("The salary is INR " + salary + " and the bonus is INR " + bonus +
                ". Hence Total Income is INR " + totalIncome);

        sc.close();
    }
}
