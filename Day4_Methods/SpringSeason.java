package Day4_Methods;

public class SpringSeason {

    public static void main(String[] args) {
        // Step 1: Take command line input
        if (args.length != 2) {
            System.out.println("Please provide month and day as command line arguments.");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        // Step 2: Check if it's spring season
        if (isSpringSeason(month, day)) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }

    // Step 2: Method to check Spring Season
    public static boolean isSpringSeason(int month, int day) {
        if ((month == 3 && day >= 20) ||
                (month == 4) ||
                (month == 5) ||
                (month == 6 && day <= 20)) {
            return true;
        }
        return false;
    }
}
