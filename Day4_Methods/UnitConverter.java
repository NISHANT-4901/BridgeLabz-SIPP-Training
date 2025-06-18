package Day4_Methods;

public class UnitConverter {

    // 1. Convert Kilometers to Miles
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    // 2. Convert Miles to Kilometers
    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    // 3. Convert Meters to Feet
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    // 4. Convert Feet to Meters
    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    // Optional: Main method for testing
    public static void main(String[] args) {
        System.out.println("10 km in miles: " + convertKmToMiles(10));
        System.out.println("6.2 miles in km: " + convertMilesToKm(6.2));
        System.out.println("5 meters in feet: " + convertMetersToFeet(5));
        System.out.println("16.4 feet in meters: " + convertFeetToMeters(16.4));
    }
}
