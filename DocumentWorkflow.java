import java.util.*;

class Document {
    String name;
    boolean isValid = false;
    boolean isReviewed = false;
    boolean isApproved = false;

    public Document(String name) {
        this.name = name;
    }

    public String getStatus() {
        return (isValid && isReviewed && isApproved) ? "Approved" : "Rejected";
    }
}

interface WorkflowStep {
    void execute(Document doc);
}

class ValidateStep implements WorkflowStep {
    public void execute(Document doc) {
        doc.isValid = Math.random() > 0.1; // 90% chance to pass validation
    }
}

class ReviewStep implements WorkflowStep {
    public void execute(Document doc) {
        if (doc.isValid) {
            doc.isReviewed = Math.random() > 0.2; // 80% chance to pass review
        }
    }
}

class ApproveStep implements WorkflowStep {
    public void execute(Document doc) {
        if (doc.isValid && doc.isReviewed) {
            doc.isApproved = Math.random() > 0.1; // 90% chance to be approved
        }
    }
}

public class DocumentWorkflow {
    public static void main(String[] args) {
        List<Document> documents = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            documents.add(new Document("Document " + i));
        }

        List<WorkflowStep> workflow = new ArrayList<>();
        workflow.add(new ValidateStep());
        workflow.add(new ReviewStep());
        workflow.add(new ApproveStep());

        for (Document doc : documents) {
            for (WorkflowStep step : workflow) {
                step.execute(doc);
            }
        }

        System.out.println("Final Document Statuses:");
        System.out.println("--------------------------");
        for (Document doc : documents) {
            System.out.println(doc.name + " → " + doc.getStatus());
        }
    }
}
