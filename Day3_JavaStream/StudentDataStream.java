package Day3_JavaStream;

import java.io.*;

public class StudentDataStream {
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        // Step 1: Write student data to file
        writeStudentData();

        // Step 2: Read student data from file
        readStudentData();
    }

    public static void writeStudentData() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            // Sample student data
            dos.writeInt(1);
            dos.writeUTF("Nishant");
            dos.writeDouble(8.7);

            dos.writeInt(2);
            dos.writeUTF("Anjali");
            dos.writeDouble(9.1);

            dos.writeInt(3);
            dos.writeUTF("Ravi");
            dos.writeDouble(7.9);

            System.out.println("Student data written to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error writing student data: " + e.getMessage());
        }
    }

    public static void readStudentData() {
        System.out.println("\nReading student data from file:");

        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.printf("Roll: %d, Name: %s, GPA: %.2f%n", roll, name, gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading student data: " + e.getMessage());
        }
    }
}
