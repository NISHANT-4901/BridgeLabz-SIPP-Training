
import java.util.Scanner;

public class CheckDevisibility {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sc.close();

        if (number % 5 == 0) {
            System.out.println("Is number " + number + " divisible by 5? " + true);
        } else {
            System.out.println("Is number " + number + " divisible by 5? " + false);
        }
    }
}