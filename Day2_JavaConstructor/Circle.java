package Day2_JavaConstructor;

public class Circle {
    private double radius;

    // Default constructor
    public Circle() {
        this(1.0);
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to display circle details
    public void displayDetails() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + (Math.PI * radius * radius));
    }

    public static void main(String[] args) {
        Circle defaultCircle = new Circle(); // Uses default constructor
        Circle customCircle = new Circle(5.5); // Uses parameterized constructor

        System.out.println("Default Circle:");
        defaultCircle.displayDetails();

        System.out.println("\nCustom Circle:");
        customCircle.displayDetails();
    }
}
