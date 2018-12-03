import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by DIMA, on 23.07.2018
 */
public class SumOddNumbers352 {
    public static long sumOfOddNumbersInRange(long start, long end) {
        // write your code here
        return LongStream.rangeClosed(start, end).filter(x -> x%2 != 0).reduce((x1,x2) -> x1+x2).orElse(0);
    }

    public static void main(String[] args) {
        System.out.println(sumOfOddNumbersInRange(-5, 7));
    }
}
