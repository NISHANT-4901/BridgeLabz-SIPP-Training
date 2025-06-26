package Day2_JavaConstructor;

public class Course {
    private String courseName;
    private int duration;
    private int fee;

    // Class variable
    private static String instituteName = "Default Institute";

    // Constructor
    public Course(String courseName, int duration, int fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: " + fee);
        System.out.println("Institute: " + instituteName);
    }

    // Class method to update institute name
    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {
        Course.updateInstituteName("BridgeLabz Academy");

        Course c1 = new Course("Java Full Stack", 12, 15000);
        Course c2 = new Course("Data Science", 16, 20000);

        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
    }
}
