public class LoggerDemo {
    public static void main(String[] args) {
        TransactionLogger logger1 = TransactionLogger.getInstance();
        logger1.log("UPI payment of Rs. 500 processed");

        TransactionLogger logger2 = TransactionLogger.getInstance();
        logger2.log("Card payment of Rs. 1200 processed");

        System.out.println("Are both references the same instance? " + (logger1 == logger2));

        logger1.printHistory();
    }
}
