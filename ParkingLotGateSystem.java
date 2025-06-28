import java.util.Scanner;

public class ParkingLotGateSystem {

    static Scanner sc = new Scanner(System.in);
    static int parkingCapacity;
    static int parkedVehicle = 0;

    static {
        System.out.print("Enter parking capacity: ");
        parkingCapacity = sc.nextInt();
    }

    public static void main(String[] args) {

        while (parkedVehicle < parkingCapacity) {
            logicBuilding();
        }

    }

    static int userCount = 0;

    static void logicBuilding() {
        int availabity = parkingCapacity - parkedVehicle;

        if (availabity > 0) {
            userCount++;
            System.out.println("User count: - " + userCount);
            System.out.println("User parked their vehicle !!");
            parkedVehicle++;

            System.out.println("Do you want to exit the parking? (true/false)");
            boolean decision = sc.nextBoolean();

            if (decision == true) {
                parkedVehicle--;
            }
        } else {
            System.out.println("Sorry but parking is full !!");
        }

    }

}
