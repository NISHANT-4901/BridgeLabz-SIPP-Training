import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      
        System.out.print("Enter first date (yyyy-MM-dd): ");
        String firstDateInput = sc.nextLine();
        System.out.print("Enter second date (yyyy-MM-dd): ");
        String secondDateInput = sc.nextLine();

        // Parse input strings into LocalDate objects
        LocalDate date1 = LocalDate.parse(firstDateInput);
        LocalDate date2 = LocalDate.parse(secondDateInput);

        // Compare the two dates
        if (date1.isBefore(date2)) {
            System.out.println("First date is before the second date.");
        } else if (date1.isAfter(date2)) {
            System.out.println("First date is after the second date.");
        } else if (date1.isEqual(date2)) {
            System.out.println("Both dates are the same.");
        }

        sc.close();
    }
}
