public class ThreadSafetyTest {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            TransactionLogger logger = TransactionLogger.getInstance();
            System.out.println(Thread.currentThread().getName() + " -> " + logger.hashCode());
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
