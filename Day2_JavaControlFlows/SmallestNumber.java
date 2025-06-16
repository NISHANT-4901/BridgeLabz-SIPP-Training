import java.util.Scanner;

public class SmallestNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.close();

        int minValue = l;

        if (m < minValue) {
            minValue = m;
        }

        if (n < minValue) {
            minValue = n;
        }

        System.out.println("Is the first number the smallest? " + minValue);
    }
}
