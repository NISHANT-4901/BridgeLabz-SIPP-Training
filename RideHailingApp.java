interface IRideService {
    void bookRide(String location, double distance);

    void endRide();
}

abstract class Vehicle {
    private String vehicleNumber;
    private int capacity;
    private String type;

    public Vehicle(String vehicleNumber, int capacity, String type) {
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.type = type;
    }

    public abstract double calculateFare(double distance);
}

class Mini extends Vehicle {
    public Mini(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "Mini");
    }

    public double calculateFare(double distance) {
        return 50 + distance * 10;
    }
}

class Sedan extends Vehicle {
    public Sedan(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "Sedan");
    }

    public double calculateFare(double distance) {
        return 70 + distance * 12;
    }
}

class SUV extends Vehicle {
    public SUV(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "SUV");
    }

    public double calculateFare(double distance) {
        return 100 + distance * 15;
    }
}

class Driver {
    private String name;
    private String licenseNumber;
    private double rating;

    public Driver(String name, String licenseNumber, double rating) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }
}

class AvailabilityManager {
    static int vehicleAvailability = 4;
    static int driverAvailability = 4;

    public static boolean isAvailable() {
        return vehicleAvailability > 0 && driverAvailability > 0;
    }

    public static void decrementAvailability() {
        if (isAvailable()) {
            vehicleAvailability--;
            driverAvailability--;
        }
    }

    public static void showAvailability() {
        System.out.println("Vehicles available: " + vehicleAvailability);
        System.out.println("Drivers available: " + driverAvailability);
    }
}

class RideManager implements IRideService {
    private Vehicle vehicle;
    private Driver driver;
    private String location;
    private double fare;

    public RideManager(Vehicle vehicle, Driver driver) {
        this.vehicle = vehicle;
        this.driver = driver;
    }

    public void bookRide(String location, double distance) {
        if (!AvailabilityManager.isAvailable()) {
            System.out.println("No vehicles or drivers available right now.");
            return;
        }

        AvailabilityManager.decrementAvailability();
        this.location = location;
        fare = vehicle.calculateFare(distance);
        System.out.println("Ride booked to " + location);
        System.out.println("Driver: " + driver.getName());
        System.out.println("Fare: " + fare);
    }

    public void endRide() {
        System.out.println("Ride ended at " + location);
    }
}

public class RideHailingApp {
    public static void main(String[] args) {
        AvailabilityManager.showAvailability();

        Vehicle vehicle = new Sedan("DL01AB1234", 4);
        Driver driver = new Driver("Ravi", "LIC123456", 4.8);
        RideManager ride = new RideManager(vehicle, driver);

        ride.bookRide("GLA", 12.5);
        ride.endRide();

        AvailabilityManager.showAvailability();
    }
}
