import java.util.Scanner;

public class coffeeCounterChronicles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of customer in cafe: - ");
        int n = sc.nextInt();
        int price = 100;

        while (n > 0) {
            System.out.println("Enter coffe type : ");
            String coffeeString = sc.nextLine();
            sc.nextLine();
            System.out.println("Enter quantity of coffee");
            int quantity = sc.nextInt();
            logicBuilding(coffeeString, quantity, price);

            n--;

        }

        sc.close();

    }

    static void logicBuilding(String coffeType, int quantity, int price) {
        int totalAmount = quantity * price;
        int incGst = gstCalculator(totalAmount);
        System.out.println(coffeType + " : " + incGst);
    }

    static int gstCalculator(int amount) {
        int gst = (amount * 18) / 100;
        return amount + gst;
    }
}
