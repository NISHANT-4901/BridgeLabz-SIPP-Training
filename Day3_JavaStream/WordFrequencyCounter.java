package Day3_JavaStream;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String filePath = "input.txt"; // Change the path if needed

        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Remove punctuation and convert to lowercase
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Total number of words
            int totalWords = wordCountMap.values().stream().mapToInt(i -> i).sum();
            System.out.println("Total number of words: " + totalWords);

            // Sort by frequency (descending)
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCountMap.entrySet());
            sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            System.out.println("Top 5 most frequent words:");
            for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
                Map.Entry<String, Integer> entry = sortedList.get(i);
                System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue());
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
