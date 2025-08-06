package Day3_JavaStream;

import java.io.*;

public class PipedStreamDemo {
    public static void main(String[] args) {
        try {
            // Create the piped input and output streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            // Create writer and reader threads
            Thread writerThread = new Thread(new WriterTask(pos), "WriterThread");
            Thread readerThread = new Thread(new ReaderTask(pis), "ReaderThread");

            // Start both threads
            writerThread.start();
            readerThread.start();

        } catch (IOException e) {
            System.out.println("Pipe connection error: " + e.getMessage());
        }
    }
}

// Writer thread writes data to the pipe
class WriterTask implements Runnable {
    private PipedOutputStream pos;

    public WriterTask(PipedOutputStream pos) {
        this.pos = pos;
    }

    public void run() {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(pos))) {
            String[] messages = {
                    "Hello from writer thread!",
                    "Piped streams are cool.",
                    "Inter-thread communication works.",
                    "Bye!"
            };

            for (String msg : messages) {
                writer.write(msg);
                writer.newLine(); // flushes newline
                writer.flush();
                Thread.sleep(1000); // simulate processing delay
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Writer error: " + e.getMessage());
        }
    }
}

// Reader thread reads data from the pipe
class ReaderTask implements Runnable {
    private PipedInputStream pis;

    public ReaderTask(PipedInputStream pis) {
        this.pis = pis;
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(pis))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Reader received: " + line);
            }
        } catch (IOException e) {
            System.out.println("Reader error: " + e.getMessage());
        }
    }
}
