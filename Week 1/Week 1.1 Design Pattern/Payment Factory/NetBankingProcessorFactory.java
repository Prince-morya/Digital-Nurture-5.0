public class NetBankingProcessorFactory extends PaymentProcessorFactory {
    @Override
    protected PaymentProcessor createProcessor() {
        return new NetBankingPayment();
    }
}
