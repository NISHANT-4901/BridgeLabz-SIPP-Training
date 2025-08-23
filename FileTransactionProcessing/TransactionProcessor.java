package FileTransactionProcessing;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class TransactionProcessor {

    public static void main(String[] args) {
        Path filePath = Paths.get("transactions.txt");


        try {
            // --------------- CASE 1: Ignore Invalid Entries -----------------
            List<Integer> validTransactions = Files.lines(filePath)
                    .flatMap(line -> {
                        try {
                            return Stream.of(Integer.parseInt(line.trim()));
                        } catch (NumberFormatException e) {
                            return Stream.empty(); 
                        }
                    })
                    .collect(Collectors.toList());

            int sum = validTransactions.stream().mapToInt(Integer::intValue).sum();
            int max = validTransactions.stream().mapToInt(Integer::intValue).max().orElseThrow();

            System.out.println("Ignoring invalid entries:");
            System.out.println("Max Transaction = " + max);
            System.out.println("Sum of Transactions = " + sum);

            // --------------- CASE 2: Throw Exception on Invalid --------------
            List<String> allLines = Files.readAllLines(filePath);
            for (int i = 0; i < allLines.size(); i++) {
                String line = allLines.get(i).trim();
                try {
                    Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    throw new InvalidTransactionEntryException(
                            "Invalid transaction data: "  + line
                    );
                }
            }
            

            System.out.println("All entries are valid!");

        } catch (InvalidTransactionEntryException e) {
            System.err.println("ERROR: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
