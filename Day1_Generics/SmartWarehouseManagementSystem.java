package Day1_Generics;
import java.util.*;

public class SmartWarehouseManagementSystem {
    abstract static class WarehouseItem {
        String name;

        WarehouseItem(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }
    }

    static class Electronics extends WarehouseItem {
        Electronics(String name) {
            super(name);
        }
    }

    static class Groceries extends WarehouseItem {
        Groceries(String name) {
            super(name);
        }
    }

    static class Furniture extends WarehouseItem {
        Furniture(String name) {
            super(name);
        }
    }

    static class Storage<T extends WarehouseItem> {
        private List<T> items = new ArrayList<>();

        void addItem(T item) {
            items.add(item);
        }

        List<T> getItems() {
            return items;
        }
    }

    static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getName());
        }
    }

    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Rice"));
        groceriesStorage.addItem(new Groceries("Wheat"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        displayAllItems(electronicsStorage.getItems());
        displayAllItems(groceriesStorage.getItems());
        displayAllItems(furnitureStorage.getItems());
    }
}
