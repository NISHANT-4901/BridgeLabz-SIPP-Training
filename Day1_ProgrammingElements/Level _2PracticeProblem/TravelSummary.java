package Day1_ProgrammingElements;

import java.util.Scanner;

public class TravelSummary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take name and cities as input
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter from city: ");
        String fromCity = sc.nextLine();

        System.out.print("Enter via city: ");
        String viaCity = sc.nextLine();

        System.out.print("Enter to city: ");
        String toCity = sc.nextLine();

        // Step 2: Distances (in miles)
        System.out.print("Enter distance from " + fromCity + " to " + viaCity + " (in miles): ");
        double fromToVia = sc.nextDouble();

        System.out.print("Enter distance from " + viaCity + " to " + toCity + " (in miles): ");
        double viaToFinalCity = sc.nextDouble();

        // Step 3: Time (in minutes)
        System.out.print("Enter time from " + fromCity + " to " + viaCity + " (in minutes): ");
        int timeFromToVia = sc.nextInt();

        System.out.print("Enter time from " + viaCity + " to " + toCity + " (in minutes): ");
        int timeViaToFinalCity = sc.nextInt();

        // Step 4: Calculations
        double totalDistanceMiles = fromToVia + viaToFinalCity;
        double totalDistanceKm = totalDistanceMiles * 1.60934; // 1 mile = 1.60934 km
        int totalTime = timeFromToVia + timeViaToFinalCity;

        // Step 5: Output
        System.out.println("\nThe Total Distance travelled by " + name + " from " + fromCity +
                " to " + toCity + " via " + viaCity + " is " + String.format("%.2f", totalDistanceKm) +
                " km and the Total Time taken is " + totalTime + " minutes.");

        sc.close();
    }
}
