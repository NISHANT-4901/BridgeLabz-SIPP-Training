package Day2_JavaConstructor;

public class Vehicle {
    private String ownerName;
    private String vehicleType;

    // Class variable
    private static int registrationFee = 5000;

    // Constructor
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    // Class method to update registration fee
    public static void updateRegistrationFee(int newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        Vehicle.updateRegistrationFee(7500);

        Vehicle v1 = new Vehicle("Nishant", "Bike");
        Vehicle v2 = new Vehicle("Ravi", "Car");

        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
    }
}
