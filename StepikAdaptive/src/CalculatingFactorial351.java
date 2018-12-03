import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by DIMA on 18.07.2018.
 */
public class CalculatingFactorial351 {
    public static long factorial(long n) {
        return LongStream.rangeClosed(1, n).reduce((s, t) -> s*t).orElse(1);

    }

    public static void main(String[] args) {
        System.out.println(CalculatingFactorial351.factorial(6));
    }
}
