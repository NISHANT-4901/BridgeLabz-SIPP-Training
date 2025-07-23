import java.util.ArrayList;
import java.util.List;

public class DynamicOnlineMarketplace {
    interface Category {
        String getCategoryName();
    }

    static class BookCategory implements Category {
        public String getCategoryName() {
            return "Book";
        }
    }

    static class ClothingCategory implements Category {
        public String getCategoryName() {
            return "Clothing";
        }
    }

    static class GadgetCategory implements Category {
        public String getCategoryName() {
            return "Gadget";
        }
    }

    static class Product<T extends Category> {
        private String name;
        private double price;
        private T category;

        Product(String name, double price, T category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        String getName() {
            return name;
        }

        double getPrice() {
            return price;
        }

        void setPrice(double price) {
            this.price = price;
        }

        T getCategory() {
            return category;
        }
    }

    static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(discountedPrice);
    }

    public static void main(String[] args) {
        List<Product<?>> catalog = new ArrayList<>();

        Product<BookCategory> book = new Product<>("Java Programming", 500, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Cotton Shirt", 800, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 15000, new GadgetCategory());

        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        applyDiscount(book, 10);
        applyDiscount(shirt, 15);
        applyDiscount(phone, 5);

        for (Product<?> product : catalog) {
            System.out.println(
                    product.getName() + " | " + product.getCategory().getCategoryName() + " | ₹" + product.getPrice());
        }
    }
}
