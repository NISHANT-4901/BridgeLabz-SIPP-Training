package Day3_thisStaticFinalKeywords;

public class ShoppingCartSystem {

    static class Product {
        // Static variable: discount percentage shared across all products
        static double discount = 10.0; // default 10%

        // Final variable: productID cannot be changed after initialization
        final int productID;
        String productName;
        double price;
        int quantity;

        // Constructor using 'this' keyword
        Product(int productID, String productName, double price, int quantity) {
            this.productID = productID;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        // Static method to update discount
        static void updateDiscount(double newDiscount) {
            discount = newDiscount;
            System.out.println("Updated discount: " + discount + "%");
        }

        // Method to calculate total price after applying discount
        double getTotalPrice() {
            double total = price * quantity;
            double discountedPrice = total - (total * discount / 100);
            return discountedPrice;
        }

        // Display product details after instanceof check
        void displayDetails() {
            if (this instanceof Product) {
                System.out.println("Product ID: " + productID);
                System.out.println("Product Name: " + productName);
                System.out.println("Price per unit: ₹" + price);
                System.out.println("Quantity: " + quantity);
                System.out.println("Discount: " + discount + "%");
                System.out.println("Total after discount: ₹" + getTotalPrice());
            }
        }
    }

    public static void main(String[] args) {
        // Create product objects
        Product p1 = new Product(101, "Laptop", 50000, 1);
        Product p2 = new Product(102, "Headphones", 2000, 2);

        // Display initial details
        System.out.println("=== Cart Summary ===");
        p1.displayDetails();
        System.out.println();
        p2.displayDetails();

        // Update discount globally
        System.out.println("\n--- Updating Discount to 20% ---");
        Product.updateDiscount(20);

        // Display updated details
        System.out.println("\n=== Cart Summary After Discount Update ===");
        p1.displayDetails();
        System.out.println();
        p2.displayDetails();
    }
}
