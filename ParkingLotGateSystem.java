import java.util.Scanner;

public class ParkingLotGateSystem {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter capacity of parking");
        int parkingCapacity = sc.nextInt();
        System.out.println("Enter number of Users");
        int numberOfUsers = sc.nextInt();

        while (parkingCapacity == 0 || isParkFull(parkingCapacity, numberOfUsers)) {
            logicBuilding(parkingCapacity, numberOfUsers);
        }

        logicBuilding(parkingCapacity, numberOfUsers);
    }

    static void logicBuilding(int numberOfUsers, int parkingCapacity) {
        int availabity = showOccupancy(parkingCapacity, numberOfUsers);
        if (availabity > 0) {
            park();
        }
        numberOfUsers--;
        
        System.out.println("If you want to exit");
        boolean decision = sc.nextBoolean();
        if (decision == true) {
            numberOfUsers++;
        }

    }

    static void park() {
        System.out.println("User parked their vehicle !!");
    }

    static int showOccupancy(int parkingCapacity, int numberOfUsers) {
        int calculation = parkingCapacity - numberOfUsers;
        return calculation;
    }

    static boolean isParkFull(int parkingCapacity, int numberOfUsers) {
        if (parkingCapacity == numberOfUsers)
            return true;

        return false;
        // TO CHANGE COMMIT
    }

}
