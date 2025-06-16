// package Day1_ProgrammingElements;
// Question: 2. Perimeter of a Rectangle

import java.util.Scanner;

public class RectanglePerameter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int w = sc.nextInt();
        sc.close();

        int Perimeter = 2 * (l + w);
        System.out.println(Perimeter);

    }
}
