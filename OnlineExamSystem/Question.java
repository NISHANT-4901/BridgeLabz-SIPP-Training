package OnlineExamSystem;

import java.util.*;

class Question {
    public static Map<String, List<String>> questionTexts = new HashMap<>();
    public static Map<String, List<String>> correctAnswers = new HashMap<>();
    public static Map<String, List<Map<Character, String>>> options = new HashMap<>();

    static {
        // COMPUTER NETWORK
        questionTexts.put("Computer Network", Arrays.asList(
                "Which protocol is used for fast unreliable transmission?",
                "Which OSI layer handles physical addressing?",
                "How many layers in the OSI model?",
                "Which device is used to connect different networks?",
                "Which address is used to uniquely identify a device?"));
        correctAnswers.put("Computer Network", Arrays.asList("c", "a", "b", "b", "c"));
        options.put("Computer Network", Arrays.asList(
                Map.of('a', "IP", 'b', "TCP", 'c', "UDP", 'd', "FTP"),
                Map.of('a', "Data Link", 'b', "Application", 'c', "Transport", 'd', "Session"),
                Map.of('a', "3", 'b', "7", 'c', "2", 'd', "5"),
                Map.of('a', "Fiber", 'b', "Router", 'c', "Switch", 'd', "Bridge"),
                Map.of('a', "OSI", 'b', "LAN", 'c', "MAC", 'd', "NIC")));

        // OPERATING SYSTEM
        questionTexts.put("Operating System", Arrays.asList(
                "What is the core part of an OS?",
                "Which of these is a deadlock condition?",
                "Which is used to synchronize threads?",
                "Which state is not part of process lifecycle?",
                "Which feature allows multiple tasks to run?"));
        correctAnswers.put("Operating System", Arrays.asList("a", "c", "b", "d", "a"));
        options.put("Operating System", Arrays.asList(
                Map.of('a', "Kernel", 'b', "Process", 'c', "Memory", 'd', "System"),
                Map.of('a', "Mutex", 'b', "Paging", 'c', "Deadlock", 'd', "Scheduler"),
                Map.of('a', "Thread", 'b', "Semaphore", 'c', "Cache", 'd', "Buffer"),
                Map.of('a', "Ready", 'b', "Wait", 'c', "Run", 'd', "Exit"),
                Map.of('a', "Multitasking", 'b', "Debugging", 'c', "Virtualization", 'd', "BIOS")));

        // DSA
        questionTexts.put("DSA", Arrays.asList(
                "Which data structure uses FIFO?",
                "What is time complexity of linear search?",
                "Which structure is used to represent networks?",
                "Which algorithm is used in binary search?",
                "What is time complexity of Merge Sort?"));
        correctAnswers.put("DSA", Arrays.asList("b", "a", "d", "c", "a"));
        options.put("DSA", Arrays.asList(
                Map.of('a', "Stack", 'b', "Queue", 'c', "Array", 'd', "Heap"),
                Map.of('a', "O(n)", 'b', "O(1)", 'c', "O(log n)", 'd', "O(n^2)"),
                Map.of('a', "Stack", 'b', "Queue", 'c', "List", 'd', "Graph"),
                Map.of('a', "DFS", 'b', "BFS", 'c', "Binary Search", 'd', "Heapify"),
                Map.of('a', "O(n log n)", 'b', "O(n^2)", 'c', "O(log n)", 'd', "O(n)")));
    }

    // Accessor methods
    public static List<Map<Character, String>> getOptions(String subject) {
        return options.get(subject);
    }

    public static List<String> getCorrectAnswers(String subject) {
        return correctAnswers.get(subject);
    }

    public static List<String> getQuestions(String subject) {
        return questionTexts.get(subject);
    }
}
