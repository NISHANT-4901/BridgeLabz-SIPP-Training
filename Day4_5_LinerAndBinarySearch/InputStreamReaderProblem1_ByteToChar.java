package Day4_5_LinerAndBinarySearch;

import java.io.*;

public class InputStreamReaderProblem1_ByteToChar {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("sample.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
        isr.close();
        fis.close();
    }
}
