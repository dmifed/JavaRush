import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by DIMA, on 24.08.2018
 */
public class ArithmeticAverage133 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        scanner.close();

        double average = IntStream.rangeClosed(start, end).filter( x -> x%3 == 0).average().orElse(0);
        System.out.println(average);
    }
}
