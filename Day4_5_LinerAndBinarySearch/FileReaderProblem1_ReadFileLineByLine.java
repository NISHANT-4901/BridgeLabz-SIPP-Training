package Day4_5_LinerAndBinarySearch;

import java.io.*;

public class FileReaderProblem1_ReadFileLineByLine {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("sample.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
        fr.close();
    }
}
