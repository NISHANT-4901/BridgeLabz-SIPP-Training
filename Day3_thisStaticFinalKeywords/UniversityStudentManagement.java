package Day3_thisStaticFinalKeywords;

public class UniversityStudentManagement {
    // Static variable shared across all instances
    static String universityName = "OpenAI University";
    static int totalStudents = 0;

    // Instance variables
    private String name;
    private final int rollNumber; // final: cannot be changed once set
    private String grade;

    // Constructor using 'this'
    UniversityStudentManagement(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++; // track total number of students
    }

    // Method to update grade
    public void updateGrade(String newGrade) {
        this.grade = newGrade;
    }

    // Method to display student details
    public void displayInfo() {
        System.out.println("University: " + universityName);
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
        System.out.println();
    }

    // Static method
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // Main method
    public static void main(String[] args) {
        UniversityStudentManagement s1 = new UniversityStudentManagement("Nishant", 101, "A");
        UniversityStudentManagement s2 = new UniversityStudentManagement("Kumar", 102, "B");

        // Check instanceof before displaying
        if (s1 instanceof UniversityStudentManagement) {
            s1.displayInfo();
        }

        if (s2 instanceof UniversityStudentManagement) {
            s2.displayInfo();
        }

        // Display total students
        UniversityStudentManagement.displayTotalStudents();
    }
}
