// package Day1_ProgrammingElements;
// Question: 4. Area of a Circle

import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int radius = sc.nextInt();
        sc.close();

        double Area = Math.PI * radius * radius;
        System.out.println(Area);

    }

}
