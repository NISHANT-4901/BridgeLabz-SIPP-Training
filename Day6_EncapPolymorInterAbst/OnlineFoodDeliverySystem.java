package Day6_EncapPolymorInterAbst;

// OnlineFoodDeliverySystem.java

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }
}

interface Discountable {
    double applyDiscount();

    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.1; // 10% discount
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount applied on Veg Item";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private final double extraCharge = 20.0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + extraCharge) * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; // 5% discount
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount applied on Non-Veg Item";
    }
}

public class OnlineFoodDeliverySystem {
    public static void processOrder(FoodItem item) {
        item.getItemDetails();
        double totalPrice = item.calculateTotalPrice();

        if (item instanceof Discountable) {
            Discountable d = (Discountable) item;
            double discount = d.applyDiscount();
            System.out.println(d.getDiscountDetails());
            System.out.println("Discount: " + discount);
            totalPrice -= discount;
        }

        System.out.println("Final Price: " + totalPrice);
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        FoodItem item1 = new VegItem("Paneer Tikka", 180, 2);
        FoodItem item2 = new NonVegItem("Chicken Biryani", 220, 1);

        processOrder(item1);
        processOrder(item2);
    }
}
