package CabInvoiceGenerator;

class InvoiceService {
    int totalRides;
    double totalFare;
    double avgFare;

    InvoiceService(int totalRides, double totalFare) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.avgFare = totalFare / totalRides;
    }

    public String toString() {
        return "Rides: " + totalRides + ", Total Fare: " + totalFare + ", Average Fare: " + avgFare;
    }
}
