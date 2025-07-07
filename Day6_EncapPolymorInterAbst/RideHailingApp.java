package Day6_EncapPolymorInterAbst;

// GPS Interface
interface GPS {
    String getCurrentLocation();

    void updateLocation(String newLocation);
}

// Abstract Class Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: " + ratePerKm);
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }
}

// Car Class
class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Bike Class
class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Auto Class
class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Runner class to demonstrate functionality
public class RideHailingApp {
    public static void main(String[] args) {
        Vehicle car = new Car("C101", "Ravi", 15.0, "Central Station");
        Vehicle bike = new Bike("B202", "Karan", 8.0, "City Mall");
        Vehicle auto = new Auto("A303", "Manoj", 10.0, "Bus Stop");

        Vehicle[] vehicles = { car, bike, auto };
        double distance = 12.5;

        for (Vehicle v : vehicles) {
            v.getVehicleDetails();
            System.out.println("Fare for " + distance + " km: " + v.calculateFare(distance));
            System.out.println("-------------");
        }
    }
}
