package Day1_ProgrammingElements;

public class CourseFeeDiscount {
    public static void main(String[] args) {
        int fee = 125000;
        int discountPercent = 10;

        // Calculate discount amount
        double discount = (fee * discountPercent) / 100.0;

        // Calculate final price after discount
        double finalFee = fee - discount;

        // Print the results
        System.out.println("The discount amount is INR " + discount +
                " and final discounted fee is INR " + finalFee);
    }
}
