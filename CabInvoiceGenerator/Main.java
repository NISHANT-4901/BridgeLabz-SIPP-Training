package CabInvoiceGenerator;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static double distance;
    static double time;

    public static void main(String[] args) {

        System.out.println("Do you prefer premimum ride ?(true/false)");
        boolean preferPremimumRide = sc.nextBoolean();
        sc.nextLine();
        if (preferPremimumRide) {
            premiumRideSystem();
        } else {
            normalRideSystem();
        }

    }

    static void normalRideSystem() {
        Ride[] ride1 = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        Ride[] ride2 = {
                new Ride(2.0, 5),
                new Ride(0.1, 1),
                new Ride(2.0, 5),
                new Ride(0.1, 1)
        };

        RideRepository.addRides("user1", ride1);
        RideRepository.addRides("user2", ride2);

        System.out.println("Input user it's userID to view their invoice");
        String userSpecific = sc.nextLine();

        if (RideRepository.userRides.containsKey(userSpecific)) {
            RideRepository.getRides(userSpecific);
            Ride[] rides = RideRepository.getRides(userSpecific);
            System.out.println("---------------------------------------------");
            for (int i = 0; i < rides.length; i++) {
                Ride r = rides[i];
                System.out.println(userSpecific + " --> " + "Distance : - " + r.distance + " Time:- " + r.time);
            }
            System.out.println("---------------------------------------------");

            double totalFare = CalculateFare.normalRide(distance, time);
            InvoiceService summary = new InvoiceService(rides.length, totalFare);
            System.out.println(userSpecific + ": " + summary);
        } else {
            System.out.println("You mention wrong userID !!");
        }

    }

    static void premiumRideSystem() {
        Ride[] ride1 = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        Ride[] ride2 = {
                new Ride(2.0, 5),
                new Ride(0.1, 1),
                new Ride(2.0, 5),
                new Ride(0.1, 1)
        };

        RideRepository.addRides("user1", ride1);
        RideRepository.addRides("user2", ride2);

        System.out.println("Input user it's userID to view their invoice");
        String userSpecific = sc.nextLine();

        if (RideRepository.userRides.containsKey(userSpecific)) {
            RideRepository.getRides(userSpecific);
            Ride[] rides = RideRepository.getRides(userSpecific);
            System.out.println("---------------------------------------------");
            for (int i = 0; i < rides.length; i++) {
                Ride r = rides[i];
                System.out.println(userSpecific + " --> " + "Distance : - " + r.distance + " Time:- " + r.time);
            }
            System.out.println("---------------------------------------------");
            double totalFare = CalculateFare.premiumRide(distance, time);
            InvoiceService summary = new InvoiceService(rides.length, totalFare);
            System.out.println(userSpecific + ": " + summary);

        } else {
            System.out.println("You mention wrong userID !!");
        }

    }
}
