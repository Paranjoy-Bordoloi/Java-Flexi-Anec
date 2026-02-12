import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}

class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Added: " + product.getName());
    }

    public void removeProduct(String productName) {
        Iterator<Product> iterator = products.iterator();
        boolean found = false;
        
        while (iterator.hasNext()) {
            if (iterator.next().getName().equalsIgnoreCase(productName)) {
                iterator.remove();
                System.out.println("Removed: " + productName);
                found = true;
                break; 
            }
        }
        
        if (!found) {
            System.out.println("Product not found: " + productName);
        }
    }

    public double calculateTotalCost() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void displayCart() {
        System.out.println("\n--- Your Shopping Cart ---");
        if (products.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
            System.out.printf("Total Cost: $%.2f%n", calculateTotalCost());
        }
        System.out.println("--------------------------");
    }
}

public class ShopSystem {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Laptop", 999.99));
        cart.addProduct(new Product("Mouse", 25.50));
        cart.addProduct(new Product("Keyboard", 45.00));

        cart.displayCart();

        cart.removeProduct("Mouse");

        cart.displayCart();
    }
}