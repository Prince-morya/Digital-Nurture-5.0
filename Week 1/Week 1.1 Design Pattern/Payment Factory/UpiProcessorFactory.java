public class UpiProcessorFactory extends PaymentProcessorFactory {
    @Override
    protected PaymentProcessor createProcessor() {
        return new UpiPayment();
    }
}
