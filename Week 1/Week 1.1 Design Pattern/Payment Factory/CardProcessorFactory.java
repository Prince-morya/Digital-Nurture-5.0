public class CardProcessorFactory extends PaymentProcessorFactory {
    @Override
    protected PaymentProcessor createProcessor() {
        return new CardPayment();
    }
}
