package Day5_Inheritance;

class Course {
    String courseName;
    int duration;

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void showDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " weeks");
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    void showDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " weeks, Platform: " + platform
                + ", Recorded: " + isRecorded);
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee,
            double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    void showDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " weeks, Platform: " + platform
                + ", Recorded: " + isRecorded + ", Fee: " + fee + ", Discount: " + discount + "%");
    }
}

public class CourseHierarchy {
    public static void main(String[] args) {
        PaidOnlineCourse poc = new PaidOnlineCourse("Java Programming", 6, "Udemy", true, 3999.0, 20.0);
        poc.showDetails();
    }
}
