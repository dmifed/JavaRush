import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by DIMA, on 08.10.2018
 */
public class ExitMain3133 {
    private static final int POOL_SIZE = 50;
    public static void main(final String[] args) throws Exception {
        final ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            executor.submit(() -> System.out.printf("Running %s%n", Thread.currentThread().getName()));
        }
        executor.shutdownNow();
    }
}
