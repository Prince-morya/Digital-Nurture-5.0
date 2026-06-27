import java.util.Scanner;

public class PaymentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose payment method: 1. UPI  2. Card  3. NetBanking");
        int choice = sc.nextInt();

        System.out.println("Enter amount: ");
        double amount = sc.nextDouble();

        PaymentProcessorFactory factory;

        switch (choice) {
            case 1:
                factory = new UpiProcessorFactory();
                break;
            case 2:
                factory = new CardProcessorFactory();
                break;
            case 3:
                factory = new NetBankingProcessorFactory();
                break;
            default:
                throw new IllegalArgumentException("Invalid choice entered");
        }

        factory.initiatePayment(amount);
        sc.close();
    }
}
