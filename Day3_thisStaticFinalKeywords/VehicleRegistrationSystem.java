package Day3_thisStaticFinalKeywords;

public class VehicleRegistrationSystem {
    // Static variable shared by all vehicles
    static double registrationFee = 500.0;

    // Final variable - can't be changed once assigned
    private final String registrationNumber;

    // Instance variables
    private String ownerName;
    private String vehicleType;

    // Constructor using 'this'
    VehicleRegistrationSystem(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Static method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    // Method to display vehicle details (uses instanceof)
    public void displayDetails() {
        if (this instanceof VehicleRegistrationSystem) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: " + registrationFee);
            System.out.println();
        } else {
            System.out.println("Object is not a valid Vehicle instance.");
        }
    }

    // Main method to test the class
    public static void main(String[] args) {
        VehicleRegistrationSystem v1 = new VehicleRegistrationSystem("Nishant", "Bike", "TN1234");
        VehicleRegistrationSystem v2 = new VehicleRegistrationSystem("Kumar", "Car", "DL5678");

        v1.displayDetails();
        v2.displayDetails();

        // Update fee
        updateRegistrationFee(750.0);

        // Display again after fee update
        System.out.println("After updating registration fee:");
        v1.displayDetails();
        v2.displayDetails();
    }
}
