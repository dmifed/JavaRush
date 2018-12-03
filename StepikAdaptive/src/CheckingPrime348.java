import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by DIMA, on 03.10.2018
 */
public class CheckingPrime348 {
    public static boolean isPrime(final long number) {
        return LongStream.range(2, number).filter(x -> number%x == 0).count() == 0;



        // write your code here
    }

    public static void main(String[] args) {
        System.out.println(isPrime(2));
    }
}
