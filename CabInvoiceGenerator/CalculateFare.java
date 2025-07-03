package CabInvoiceGenerator;

class CalculateFare {


    static double normalRide(double distance, double time) {
        double totalCost = (10 * distance) + (1 * time);
        if (totalCost < 5) {
            return 5;
        } else {
            return totalCost;
        }
    }

    static double premiumRide(double distance, double time) {
        double totalCost = (15 * distance) + (2 * time);
        if (totalCost < 20) {
            return 20;
        } else {
            return totalCost;
        }
    }

}
