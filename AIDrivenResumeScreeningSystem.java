import java.util.ArrayList;
import java.util.List;

public class AIDrivenResumeScreeningSystem {
    abstract static class JobRole {
        private String candidateName;

        JobRole(String candidateName) {
            this.candidateName = candidateName;
        }

        String getCandidateName() {
            return candidateName;
        }

        abstract String getRoleName();
    }

    static class SoftwareEngineer extends JobRole {
        SoftwareEngineer(String candidateName) {
            super(candidateName);
        }

        String getRoleName() {
            return "Software Engineer";
        }
    }

    static class DataScientist extends JobRole {
        DataScientist(String candidateName) {
            super(candidateName);
        }

        String getRoleName() {
            return "Data Scientist";
        }
    }

    static class ProductManager extends JobRole {
        ProductManager(String candidateName) {
            super(candidateName);
        }

        String getRoleName() {
            return "Product Manager";
        }
    }

    static class Resume<T extends JobRole> {
        private T jobRole;

        Resume(T jobRole) {
            this.jobRole = jobRole;
        }

        T getJobRole() {
            return jobRole;
        }
    }

    static <T extends JobRole> Resume<T> processResume(T jobRole) {
        return new Resume<>(jobRole);
    }

    static void screenResumes(List<? extends Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> resume : resumes) {
            JobRole role = resume.getJobRole();
            System.out.println(role.getCandidateName() + " | " + role.getRoleName());
        }
    }

    public static void main(String[] args) {
        List<Resume<? extends JobRole>> screeningQueue = new ArrayList<>();

        Resume<SoftwareEngineer> resume1 = processResume(new SoftwareEngineer("Alice"));
        Resume<DataScientist> resume2 = processResume(new DataScientist("Bob"));
        Resume<ProductManager> resume3 = processResume(new ProductManager("Charlie"));

        screeningQueue.add(resume1);
        screeningQueue.add(resume2);
        screeningQueue.add(resume3);

        screenResumes(screeningQueue);
    }
}
