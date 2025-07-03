package CabInvoiceGenerator;

import java.util.HashMap;

class RideRepository {
    static HashMap<String, Ride[]> userRides = new HashMap<>();

     static void addRides(String userID, Ride rides[]) {
        userRides.put(userID, rides);
    }

     static Ride[] getRides(String userID) {
        return userRides.get(userID);
    }
}
