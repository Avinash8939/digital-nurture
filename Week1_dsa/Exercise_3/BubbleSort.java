public class BubbleSort {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            
            
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order("O001", "Alice", 150.0),
            new Order("O002", "Bob", 1200.0),
            new Order("O003", "Charlie", 560.0),
            new Order("O004", "David", 890.0),
            new Order("O005", "Eve", 320.0)
        };

        System.out.println("Before Sorting:");
        for (Order order : orders) {
            System.out.println(order);
        }

        bubbleSort(orders);

        System.out.println("\nAfter Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    
    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

