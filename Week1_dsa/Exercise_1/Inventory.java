
import java.util.HashMap;
import java.util.Map;

class Inventory {
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        // Add products
        ims.addProduct(new Product("P001", "Laptop", 10, 999.99));
        ims.addProduct(new Product("P002", "Smartphone", 20, 499.99));
        ims.addProduct(new Product("P003", "Tablet", 15, 299.99));

        
        ims.displayProducts();

        
        ims.updateProduct(new Product("P002", "Smartphone", 18, 479.99));

        
        ims.deleteProduct("P001");

        
        ims.displayProducts();
    }
}


class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

class InventoryManagementSystem {
    private Map<String, Product> inventory;

    public InventoryManagementSystem() {
        this.inventory = new HashMap<>();
    }

    
    public void addProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            System.out.println("Product already exists. Use updateProduct to modify.");
        } else {
            inventory.put(product.getProductId(), product);
            System.out.println("Product added: " + product);
        }
    }

    
    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
            System.out.println("Product updated: " + product);
        } else {
            System.out.println("Product not found. Use addProduct to add new product.");
        }
    }

    
    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            Product removedProduct = inventory.remove(productId);
            System.out.println("Product removed: " + removedProduct);
        } else {
            System.out.println("Product not found.");
        }
    }

    
    public void displayProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            for (Product product : inventory.values()) {
                System.out.println(product);
            }
        }
    }
}





