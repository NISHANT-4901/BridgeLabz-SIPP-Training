import java.util.ArrayList;
import java.util.List;

class Flavor {
    String name;
    int sales;

    public Flavor(String name, int sales) {
        this.name = name;
        this.sales = sales;
    }

}

class IceCreamRush {
    private List<Flavor> flavors;

    public IceCreamRush() {
        flavors = new ArrayList<>();
    }

    public void addFlavor(String name, int sales) {
        flavors.add(new Flavor(name, sales));
    }

    // Bubble sort flavors by sales
    public void sortFlavorsByPopularity() {
        int n = flavors.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (flavors.get(j).sales > flavors.get(j + 1).sales) {
                    // Swap
                    Flavor temp = flavors.get(j);
                    flavors.set(j, flavors.get(j + 1));
                    flavors.set(j + 1, temp);
                }
            }
        }
    }

    public void displayFlavors() {
        for (Flavor flavor : flavors) {
            System.out.println(flavor.name + " --> " + flavor.sales);
        }
    }

    public static void main(String[] args) {
        IceCreamRush rush = new IceCreamRush();

        rush.addFlavor("falvor0", 3);
        rush.addFlavor("falvor1", 2);
        rush.addFlavor("falvor2", 5);
        rush.addFlavor("falvor3", 1);
        rush.addFlavor("falvor4", 6);
        rush.addFlavor("falvor5", 9);
        rush.addFlavor("falvor6", 14);
        rush.addFlavor("falvor7", 12);

        System.out.println("Before Sorting:");
        rush.displayFlavors();

        rush.sortFlavorsByPopularity();

        System.out.println("\nAfter Sorting by Popularity (Ascending):");
        rush.displayFlavors();
    }
}
