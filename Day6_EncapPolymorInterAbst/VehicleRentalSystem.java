package Day6_EncapPolymorInterAbst;

interface Insurable {
    double calculateInsurance();

    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    abstract double calculateRentalCost(int days);
}

class Car extends Vehicle implements Insurable {
    private String policyNumber;

    Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.policyNumber = policyNumber;
    }

    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 5000.0;
    }

    public String getInsuranceDetails() {
        return "Car Insurance - Policy: " + policyNumber;
    }
}

class Bike extends Vehicle implements Insurable {
    private String policyNumber;

    Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.policyNumber = policyNumber;
    }

    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 1000.0;
    }

    public String getInsuranceDetails() {
        return "Bike Insurance - Policy: " + policyNumber;
    }
}

class Truck extends Vehicle implements Insurable {
    private String policyNumber;

    Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.policyNumber = policyNumber;
    }

    double calculateRentalCost(int days) {
        return getRentalRate() * days + 2000.0;
    }

    public double calculateInsurance() {
        return 8000.0;
    }

    public String getInsuranceDetails() {
        return "Truck Insurance - Policy: " + policyNumber;
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car("CAR101", 1500, "POL-CAR-001");
        vehicles[1] = new Bike("BIKE202", 500, "POL-BIKE-002");
        vehicles[2] = new Truck("TRUCK303", 3000, "POL-TRUCK-003");

        int rentalDays = 5;

        for (Vehicle v : vehicles) {
            double rentalCost = v.calculateRentalCost(rentalDays);
            double insuranceCost = (v instanceof Insurable) ? ((Insurable) v).calculateInsurance() : 0;

            System.out.println("Vehicle Type: " + v.getType());
            System.out.println("Vehicle No: " + v.getVehicleNumber());
            System.out.println("Rental Cost for " + rentalDays + " days: " + rentalCost);
            System.out.println("Insurance Cost: " + insuranceCost);
            if (v instanceof Insurable) {
                System.out.println(((Insurable) v).getInsuranceDetails());
            }
            System.out.println();
        }
    }
}
