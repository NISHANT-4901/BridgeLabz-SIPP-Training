package Day2_JavaConstructor;

class Student {
    public int rollNumber; // Public: Accessible from anywhere
    protected String name; // Protected: Accessible within package and subclasses
    private double CGPA; // Private: Only accessible within this class

    // Constructor
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public method to get CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public method to set CGPA
    public void setCGPA(double CGPA) {
        if (CGPA >= 0 && CGPA <= 10)
            this.CGPA = CGPA;
        else
            System.out.println("Invalid CGPA. Must be between 0 and 10.");
    }

    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

// Subclass to demonstrate protected access
class PostgraduateStudent extends Student {

    private String researchTopic;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String researchTopic) {
        super(rollNumber, name, CGPA);
        this.researchTopic = researchTopic;
    }

    public void displayPGDetails() {
        System.out.println("Postgraduate Student Name: " + name); // accessing protected member
        System.out.println("Research Topic: " + researchTopic);
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Nishant", 8.5);
        s1.displayStudentDetails();

        System.out.println();

        PostgraduateStudent pg = new PostgraduateStudent(201, "Aman", 9.1, "AI in Education");
        pg.displayPGDetails();

        System.out.println("\nUpdating CGPA...");
        s1.setCGPA(9.3);
        System.out.println("Updated CGPA: " + s1.getCGPA());
    }
}
