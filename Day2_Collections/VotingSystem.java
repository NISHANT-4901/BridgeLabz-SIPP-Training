import java.util.*;

public class VotingSystem {
    private HashMap<String, Integer> voteMap = new HashMap<>();
    private LinkedHashMap<String, Integer> voteOrderMap = new LinkedHashMap<>();

    // Cast a vote
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteMap.get(candidate));
    }

    // Display votes in insertion order
    public void displayVoteOrder() {
        System.out.println("Votes in Order of Cast:");
        for (Map.Entry<String, Integer> entry : voteOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Display results in sorted candidate order
    public void displaySortedResults() {
        TreeMap<String, Integer> sortedVotes = new TreeMap<>(voteMap);
        System.out.println("Votes in Sorted Order:");
        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        VotingSystem voting = new VotingSystem();

        voting.castVote("Alice");
        voting.castVote("Bob");
        voting.castVote("Alice");
        voting.castVote("Charlie");
        voting.castVote("Bob");

        voting.displayVoteOrder();
        System.out.println();
        voting.displaySortedResults();
    }
}
