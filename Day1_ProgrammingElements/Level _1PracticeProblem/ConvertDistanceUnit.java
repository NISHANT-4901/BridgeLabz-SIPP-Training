// Question: 5. Convert Kilometers to Miles
// package Day1_ProgrammingElements;

import java.util.Scanner;

public class ConvertDistanceUnit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Kilometers = sc.nextInt();
        sc.close();

        double Miles = Kilometers * 0.621371;
        System.out.println(Miles);
    }

}
