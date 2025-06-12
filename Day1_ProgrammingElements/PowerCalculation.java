package Day1_ProgrammingElements;
import java.util.Scanner;

public class PowerCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double base = sc.nextDouble();
        double exponent = sc.nextDouble();
        sc.close();

        double result = Math.pow(base, exponent);
        System.out.println("Result: " + result);
    }
}
