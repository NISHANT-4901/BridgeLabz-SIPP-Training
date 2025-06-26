package Day2_JavaConstructor;

public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private int dailyRate;

    // Default constructor
    public CarRental() {
        this.customerName = "Unknown";
        this.carModel = "Standard";
        this.rentalDays = 1;
        this.dailyRate = 800; // default daily rate
    }

    // Parameterized constructor
    public CarRental(String customerName, String carModel, int rentalDays, int dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
    }

    // Method to calculate total cost
    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    // Display rental details
    public void displayDetails() {
        System.out.println("Customer: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Daily Rate: " + dailyRate);
        System.out.println("Total Cost: " + calculateTotalCost());
    }

    public static void main(String[] args) {
        CarRental rental1 = new CarRental("Nishant", "Hyundai Creta", 3, 800);
        rental1.displayDetails();

        System.out.println("\nDefault Rental:");
        CarRental rental2 = new CarRental();
        rental2.displayDetails();
    }
}
