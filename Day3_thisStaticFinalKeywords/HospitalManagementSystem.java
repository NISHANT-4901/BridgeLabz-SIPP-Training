package Day3_thisStaticFinalKeywords;

public class HospitalManagementSystem {
    // Static variable shared among all patients
    static String hospitalName = "CityCare Hospital";
    static int totalPatients = 0;

    // Final variable - uniquely identifies each patient
    private final int patientID;

    // Instance variables
    private String name;
    private int age;
    private String ailment;

    // Constructor using 'this' to initialize values
    HospitalManagementSystem(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    // Static method to get total patient count
    public static int getTotalPatients() {
        return totalPatients;
    }

    // Display patient details with instanceof check
    public void displayDetails() {
        if (this instanceof HospitalManagementSystem) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
            System.out.println();
        } else {
            System.out.println("Not a valid Patient instance.");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        HospitalManagementSystem p1 = new HospitalManagementSystem("Nishant", 21, "Fever", 1001);
        HospitalManagementSystem p2 = new HospitalManagementSystem("Kumar", 35, "Cough", 1002);

        p1.displayDetails();
        p2.displayDetails();

        System.out.println("Total patients admitted: " + getTotalPatients());
    }
}
