package Day4_5_LinerAndBinarySearch;

import java.io.*;

public class InputStreamReaderProblem2_ReadInputWriteFile {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        FileWriter fw = new FileWriter("output.txt");
        String line;
        while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
            fw.write(line + "\n");
        }
        fw.close();
        br.close();
        isr.close();
    }
}
