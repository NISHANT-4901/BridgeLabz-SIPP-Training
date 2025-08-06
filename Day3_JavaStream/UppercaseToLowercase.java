package Day3_JavaStream;

import java.io.*;

public class UppercaseToLowercase {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }

            System.out.println("All uppercase letters converted to lowercase and saved to " + outputFile);
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}
