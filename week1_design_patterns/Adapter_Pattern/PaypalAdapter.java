public class PaypalAdapter implements PaymentProcessor {
    private PaypalPayment paypalPayment;

    public PaypalAdapter(PaypalPayment paypalPayment) {
        this.paypalPayment = paypalPayment;
    }

    @Override
    public void processPayment(double amount) {
        paypalPayment.makePayment(amount);
    }
}