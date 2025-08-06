package Day3_JavaStream;

import java.io.*;

public class ErrorLineFilter {
    public static void main(String[] args) {
        String filePath = "large-log-file.txt"; // Replace with your file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                    count++;
                }
            }

            System.out.println("\nTotal lines with 'error': " + count);
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}
