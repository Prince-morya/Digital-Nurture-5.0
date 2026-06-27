public class UpiPayment implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Processing UPI payment of Rs. " + amount);
        System.out.println("Redirecting to UPI app for verification...");
    }
}
