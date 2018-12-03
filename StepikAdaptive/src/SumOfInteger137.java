import java.util.Scanner;
import java.util.stream.LongStream;

/**
 * Created by DIMA, on 01.10.2018
 */
public class SumOfInteger137 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int from = scanner.nextInt();
        int to = scanner.nextInt();

        long sum = LongStream.rangeClosed(from, to).sum();
        System.out.println(sum);
    }
}
