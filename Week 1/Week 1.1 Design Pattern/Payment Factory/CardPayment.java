public class CardPayment implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Processing Card payment of Rs. " + amount);
        System.out.println("Validating CVV and OTP...");
    }
}
