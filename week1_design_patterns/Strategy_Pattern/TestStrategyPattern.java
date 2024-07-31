public class TestStrategyPattern {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        context.executePayment(100.0);

        context.setPaymentStrategy(new PayPalPayment("example@example.com"));
        context.executePayment(200.0);
    }
}