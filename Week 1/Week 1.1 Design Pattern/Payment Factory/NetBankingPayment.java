public class NetBankingPayment implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Processing Net Banking payment of Rs. " + amount);
        System.out.println("Redirecting to bank portal...");
    }
}
