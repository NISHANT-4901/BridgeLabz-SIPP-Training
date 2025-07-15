package Day4_5_LinerAndBinarySearch;

import java.io.*;

public class ChallengeProblem_CompareBuildersAndReaders {
    public static void main(String[] args) throws IOException {
        int iterations = 1000000;
        String sample = "hello";

        long startSB = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(sample);
        }
        long endSB = System.nanoTime();
        System.out.println("StringBuilder time: " + (endSB - startSB) + " ns");

        long startSBF = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(sample);
        }
        long endSBF = System.nanoTime();
        System.out.println("StringBuffer time: " + (endSBF - startSBF) + " ns");

        FileReader fr = new FileReader("largefile.txt");
        BufferedReader brFR = new BufferedReader(fr);
        String lineFR;
        int wordCountFR = 0;
        long startFR = System.nanoTime();
        while ((lineFR = brFR.readLine()) != null) {
            wordCountFR += lineFR.split("\\s+").length;
        }
        long endFR = System.nanoTime();
        brFR.close();
        fr.close();
        System.out.println("FileReader word count: " + wordCountFR);
        System.out.println("FileReader time: " + (endFR - startFR) + " ns");

        FileInputStream fis = new FileInputStream("largefile.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader brISR = new BufferedReader(isr);
        String lineISR;
        int wordCountISR = 0;
        long startISR = System.nanoTime();
        while ((lineISR = brISR.readLine()) != null) {
            wordCountISR += lineISR.split("\\s+").length;
        }
        long endISR = System.nanoTime();
        brISR.close();
        isr.close();
        fis.close();
        System.out.println("InputStreamReader word count: " + wordCountISR);
        System.out.println("InputStreamReader time: " + (endISR - startISR) + " ns");
    }
}
