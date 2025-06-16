// package Day1_ProgrammingElements;
// Question: 5. Volume of a Cylinder

import java.util.Scanner;

public class CylinderVolume {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int h = sc.nextInt();
        sc.close();

        double Volume = Math.PI * r * r * h;
        System.out.println(Volume);
    }
}
