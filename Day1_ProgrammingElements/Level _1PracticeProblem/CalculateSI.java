// package Day1_ProgrammingElements;
// Question: 1. Calculate Simple Interest

import java.util.Scanner;

public class CalculateSI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int r = sc.nextInt();
        int t = sc.nextInt();
        sc.close();

        int SI = (p * r * t) / 100;
        System.out.println(SI);
    }
}
