/**
 * Created by DIMA, on 02.10.2018
 */
public class StartThread3121 {
    public static void main(final String[] args) {
        new Thread(() -> System.out.println("Started")).start();
    }
}
