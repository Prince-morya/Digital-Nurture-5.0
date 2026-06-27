import java.util.ArrayList;
import java.util.List;

public class TransactionLogger {

    private static volatile TransactionLogger instance;
    private List<String> transactionHistory;

    private TransactionLogger() {
        transactionHistory = new ArrayList<>();
        System.out.println("Logger instance created...");
    }

    public static TransactionLogger getInstance() {
        if (instance == null) {
            synchronized (TransactionLogger.class) {
                if (instance == null) {
                    instance = new TransactionLogger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        String entry = "[LOG] " + message;
        transactionHistory.add(entry);
        System.out.println(entry);
    }

    public void printHistory() {
        System.out.println("----- Transaction History -----");
        for (String entry : transactionHistory) {
            System.out.println(entry);
        }
    }
}
