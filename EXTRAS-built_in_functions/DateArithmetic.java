import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateArithmetic {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input format example: 2025-06-17
        System.out.print("Enter a date (yyyy-MM-dd): ");
        String inputDate = sc.nextLine();

        // Parse the input string to LocalDate
        LocalDate date = LocalDate.parse(inputDate);

        // Add 7 days, 1 month, 2 years
        LocalDate updatedDate = date.plusDays(7).plusMonths(1).plusYears(2);

        // Subtract 3 weeks
        LocalDate finalDate = updatedDate.minusWeeks(3);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("Original Date     : " + date.format(formatter));
        System.out.println("After Additions   : " + updatedDate.format(formatter));
        System.out.println("Final Date Result : " + finalDate.format(formatter));

        sc.close();
    }
}
