// package Day1_ProgrammingElements;
// Question: 2. Add Two Numbers

import java.util.Scanner;

public class AddingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        
        int sum = m + n;
        System.out.println(sum);
    }
}
