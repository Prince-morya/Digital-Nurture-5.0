public abstract class PaymentProcessorFactory {

    // this is the factory method, subclasses decide what comes back
    protected abstract PaymentProcessor createProcessor();

    // template method that depends on the factory method above
    public void initiatePayment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount should be greater than zero");
        }
        PaymentProcessor processor = createProcessor();
        processor.pay(amount);
    }
}
