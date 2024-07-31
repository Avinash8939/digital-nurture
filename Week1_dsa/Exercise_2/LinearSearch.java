class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

public class LinearSearch {

    public static int linearSearch(Product[] products, String target) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equals(target)) {
                return i; 
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Smartphone", "Electronics"),
            new Product("P003", "Tablet", "Electronics"),
            new Product("P004", "Headphones", "Accessories"),
            new Product("P005", "Camera", "Electronics")
        };

        String target = "Tablet";
        int index = linearSearch(products, target);

        if (index != -1) {
            System.out.println("Product found at index: " + index);
        } else {
            System.out.println("Product not found");
        }
    }
}

