import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input from the user
        System.out.print("Enter a year (>= 1582): ");
        int year = sc.nextInt();
        sc.close();

        // Validate Gregorian calendar start year and check leap year in single
        // condition
        if (year >= 1582 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            System.out.println(year + " is a Leap Year.");
        } else if (year >= 1582) {
            System.out.println(year + " is Not a Leap Year.");
        } else {
            System.out.println("Year is before the start of the Gregorian calendar.");
        }
    }
}
