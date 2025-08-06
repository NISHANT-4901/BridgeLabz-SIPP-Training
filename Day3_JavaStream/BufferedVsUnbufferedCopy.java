package Day3_JavaStream;

import java.io.*;

public class BufferedVsUnbufferedCopy {
    private static final int BUFFER_SIZE = 4096; // 4KB

    public static void main(String[] args) {
        String sourcePath = "largefile.txt";
        String destBuffered = "copy_buffered.txt";
        String destUnbuffered = "copy_unbuffered.txt";

        // Copy with Buffered Streams
        long bufferedTime = copyWithBufferedStreams(sourcePath, destBuffered);

        // Copy with Unbuffered Streams
        long unbufferedTime = copyWithUnbufferedStreams(sourcePath, destUnbuffered);

        System.out.println("Buffered Streams Copy Time     : " + bufferedTime + " ns");
        System.out.println("Unbuffered Streams Copy Time   : " + unbufferedTime + " ns");

        double speedup = (double) unbufferedTime / bufferedTime;
        System.out.printf("Speedup using Buffered Streams : %.2fx faster%n", speedup);
    }

    public static long copyWithBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();

        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Buffered Copy Error: " + e.getMessage());
        }

        return System.nanoTime() - startTime;
    }

    public static long copyWithUnbufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();

        try (
                FileInputStream fis = new FileInputStream(source);
                FileOutputStream fos = new FileOutputStream(destination)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Unbuffered Copy Error: " + e.getMessage());
        }

        return System.nanoTime() - startTime;
    }
}
