public class GPSbasedRoutesTracker {

    // Abstract Checkpoint class
    static abstract class Checkpoint {
        protected String checkpointId;
        protected String locationName;
        protected double distanceFromLast;
        protected int expectedDuration;
        protected int actualDuration;

        public Checkpoint(String checkpointId, String locationName, double distanceFromLast, int expectedDuration,
                int actualDuration) {
            this.checkpointId = checkpointId;
            this.locationName = locationName;
            this.distanceFromLast = distanceFromLast;
            this.expectedDuration = expectedDuration;
            this.actualDuration = actualDuration;
        }

        public abstract boolean isCritical();

        public abstract String getType();

        public abstract double calculatePenalty();

        public boolean isDelayed() {
            return actualDuration > expectedDuration;
        }

        public String getCheckpointId() {
            return checkpointId;
        }

        public String getLocationName() {
            return locationName;
        }

        public double getDistanceFromLast() {
            return distanceFromLast;
        }

        public int getExpectedDuration() {
            return expectedDuration;
        }

        public int getActualDuration() {
            return actualDuration;
        }
    }

    // Subclasses of Checkpoint
    static class DeliveryCheckpoint extends Checkpoint {
        public DeliveryCheckpoint(String checkpointId, String locationName, double distanceFromLast,
                int expectedDuration, int actualDuration) {
            super(checkpointId, locationName, distanceFromLast, expectedDuration, actualDuration);
        }

        @Override
        public boolean isCritical() {
            return true;
        }

        @Override
        public String getType() {
            return "DeliveryCheckpoint";
        }

        @Override
        public double calculatePenalty() {
            return isDelayed() ? (actualDuration - expectedDuration) * 2.0 : 0.0;
        }
    }

    static class FuelCheckpoint extends Checkpoint {
        public FuelCheckpoint(String checkpointId, String locationName, double distanceFromLast, int expectedDuration,
                int actualDuration) {
            super(checkpointId, locationName, distanceFromLast, expectedDuration, actualDuration);
        }

        @Override
        public boolean isCritical() {
            return true;
        }

        @Override
        public String getType() {
            return "FuelCheckpoint";
        }

        @Override
        public double calculatePenalty() {
            return isDelayed() ? 10.0 : 0.0;
        }
    }

    static class RestCheckpoint extends Checkpoint {
        public RestCheckpoint(String checkpointId, String locationName, double distanceFromLast, int expectedDuration,
                int actualDuration) {
            super(checkpointId, locationName, distanceFromLast, expectedDuration, actualDuration);
        }

        @Override
        public boolean isCritical() {
            return false;
        }

        @Override
        public String getType() {
            return "RestCheckpoint";
        }

        @Override
        public double calculatePenalty() {
            return (isDelayed() && (actualDuration - expectedDuration) > 30) ? (actualDuration - expectedDuration) * 0.5
                    : 0.0;
        }
    }

    // Route Linked List using Generics
    static class RouteLinkedList<T extends Checkpoint> {
        private class Node {
            T data;
            Node next;

            Node(T data) {
                this.data = data;
            }
        }

        private Node head;

        public void addCheckpoint(T checkpoint) {
            Node newNode = new Node(checkpoint);
            if (head == null)
                head = newNode;
            else {
                Node temp = head;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = newNode;
            }
        }

        public boolean removeCheckpoint(String checkpointId) {
            if (head == null)
                return false;
            if (head.data.getCheckpointId().equals(checkpointId)) {
                head = head.next;
                return true;
            }
            Node current = head;
            while (current.next != null && !current.next.data.getCheckpointId().equals(checkpointId)) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
                return true;
            }
            return false;
        }

        public T findCheckpoint(String checkpointId) {
            Node current = head;
            while (current != null) {
                if (current.data.getCheckpointId().equals(checkpointId))
                    return current.data;
                current = current.next;
            }
            return null;
        }

        public double computeTotalDistance() {
            double total = 0.0;
            Node current = head;
            while (current != null) {
                total += current.data.getDistanceFromLast();
                current = current.next;
            }
            return total;
        }

        public double computeTotalPenalty() {
            double penalty = 0.0;
            Node current = head;
            while (current != null) {
                penalty += current.data.calculatePenalty();
                current = current.next;
            }
            return penalty;
        }

        public boolean checkCriticalPointsPresent() {
            boolean hasDelivery = false, hasFuel = false;
            Node current = head;
            while (current != null) {
                if (current.data instanceof DeliveryCheckpoint)
                    hasDelivery = true;
                if (current.data instanceof FuelCheckpoint)
                    hasFuel = true;
                current = current.next;
            }
            return hasDelivery && hasFuel;
        }

        public void printRoute() {
            Node current = head;
            int count = 1;
            while (current != null) {
                T cp = current.data;
                System.out.println(count++ + ". " + cp.getType() + " --> " + cp.getLocationName()
                        + " --> " + (cp.isDelayed() ? "Delayed" : "On Time")
                        + "  Penalty: " + String.format("%.1f", cp.calculatePenalty()));
                current = current.next;
            }
        }

    }

    // Driver class
    static class Driver {
        private String driverId;
        private String name;
        private RouteLinkedList<Checkpoint> routeHistory;

        public Driver(String driverId, String name) {
            this.driverId = driverId;
            this.name = name;
            this.routeHistory = new RouteLinkedList<>();
        }

        public void addCheckpoint(Checkpoint cp) {
            routeHistory.addCheckpoint(cp);
        }

        public void printSummary() {
            System.out.println("DriverID: " + driverId + " | Driver Name: " + name);
            System.out.println("Route Summary:");
            routeHistory.printRoute();

            double totalDistance = routeHistory.computeTotalDistance();
            double totalPenalty = routeHistory.computeTotalPenalty();
            double routeScore = totalDistance - totalPenalty;

            System.out.println("Total Distance: " + totalDistance + " km");
            System.out.println("Total Penalty: " + totalPenalty);
            System.out.println("Route Score: " + routeScore);
            System.out.println("Critical Route Check: " +
                    (routeHistory.checkCriticalPointsPresent() ? "All required checkpoints present"
                            : "Missing critical checkpoints"));
        }
    }

    // Main function
    public static void main(String[] args) {
        Driver driver = new Driver("D1204", "Kavita Nair");

        driver.addCheckpoint(new DeliveryCheckpoint("C1", "GLA", 40, 30, 40)); 
        driver.addCheckpoint(new FuelCheckpoint("C2", "Pump", 30, 20, 20)); 
        driver.addCheckpoint(new RestCheckpoint("C3", "Hotel", 25, 60, 65)); 
        driver.addCheckpoint(new DeliveryCheckpoint("C4", "Capgemini", 25, 45, 60));

        driver.printSummary();
    }
}
