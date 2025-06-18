package Day4_Methods;

public class UnitConverterExtended {

    // 1. Yards to Feet
    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3.0;
        return yards * yards2feet;
    }

    // 2. Feet to Yards
    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    // 3. Meters to Inches
    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    // 4. Inches to Meters
    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    // 5. Inches to Centimeters
    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    // Optional main for quick test
    public static void main(String[] args) {
        System.out.println("5 yards in feet: " + convertYardsToFeet(5));
        System.out.println("15 feet in yards: " + convertFeetToYards(15));
        System.out.println("2 meters in inches: " + convertMetersToInches(2));
        System.out.println("10 inches in meters: " + convertInchesToMeters(10));
        System.out.println("8 inches in cm: " + convertInchesToCentimeters(8));
    }
}
