package Day1_ProgrammingElements;

public class PenDistribution {
    public static void main(String[] args) {
        int totalPens = 14;
        int students = 3;

        // Division and remainder
        int pensPerStudent = totalPens / students;
        int remainingPens = totalPens % students;

        // Output result
        System.out.println("The Pen Per Student is " + pensPerStudent +
                " and the remaining pen not distributed is " + remainingPens);
    }
}
