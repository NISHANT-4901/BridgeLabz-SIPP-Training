package Day4_5_LinerAndBinarySearch;

import java.io.*;

public class FileReaderProblem2_CountWordOccurrence {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("sample.txt");
        BufferedReader br = new BufferedReader(fr);
        String target = "hello";
        int count = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.equalsIgnoreCase(target)) {
                    count++;
                }
            }
        }
        br.close();
        fr.close();
        System.out.println("Occurrences of \"" + target + "\": " + count);
    }
}
