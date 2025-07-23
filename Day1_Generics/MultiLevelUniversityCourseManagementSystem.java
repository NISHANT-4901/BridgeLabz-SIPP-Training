package Day1_Generics;
import java.util.ArrayList;
import java.util.List;

public class MultiLevelUniversityCourseManagementSystem {
    abstract static class CourseType {
        private String courseName;

        CourseType(String courseName) {
            this.courseName = courseName;
        }

        String getCourseName() {
            return courseName;
        }

        abstract String getEvaluationMethod();
    }

    static class ExamCourse extends CourseType {
        ExamCourse(String courseName) {
            super(courseName);
        }

        String getEvaluationMethod() {
            return "Exam-Based";
        }
    }

    static class AssignmentCourse extends CourseType {
        AssignmentCourse(String courseName) {
            super(courseName);
        }

        String getEvaluationMethod() {
            return "Assignment-Based";
        }
    }

    static class ResearchCourse extends CourseType {
        ResearchCourse(String courseName) {
            super(courseName);
        }

        String getEvaluationMethod() {
            return "Research-Based";
        }
    }

    static class Course<T extends CourseType> {
        private T type;
        private String instructor;

        Course(T type, String instructor) {
            this.type = type;
            this.instructor = instructor;
        }

        T getType() {
            return type;
        }

        String getInstructor() {
            return instructor;
        }
    }

    static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.getCourseName() + " | " + course.getEvaluationMethod());
        }
    }

    public static void main(String[] args) {
        List<Course<? extends CourseType>> courseList = new ArrayList<>();

        Course<ExamCourse> math = new Course<>(new ExamCourse("Mathematics"), "Dr. Sharma");
        Course<AssignmentCourse> english = new Course<>(new AssignmentCourse("English Literature"), "Prof. Rao");
        Course<ResearchCourse> physics = new Course<>(new ResearchCourse("Quantum Physics"), "Dr. Verma");

        courseList.add(math);
        courseList.add(english);
        courseList.add(physics);

        for (Course<? extends CourseType> course : courseList) {
            System.out.println(course.getType().getCourseName() + " | " + course.getType().getEvaluationMethod() + " | "
                    + course.getInstructor());
        }
    }
}
