// package Day1_ProgrammingElements;
// Question: 3. Celsius to Fahrenheit Conversion

import java.util.Scanner;

public class TemUnitConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Celsius = sc.nextInt();
        sc.close();

        int Fahrenheit = (Celsius * 9 / 5) + 32;
        System.out.println(Fahrenheit);
    }
}
