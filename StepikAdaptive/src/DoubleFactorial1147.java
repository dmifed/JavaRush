import java.math.BigInteger;


/**
 * Created by DIMA, on 12.11.2018
 */
public class DoubleFactorial1147 {
    public static BigInteger calcDoubleFactorial(int n) {
        //if(n < 2) return BigInteger.ONE;
        return java.util.stream.IntStream
                .rangeClosed(2, n)
                .filter(i -> i % 2 == n % 2)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger::multiply)
                .orElse(BigInteger.ONE);


        // type your java code here
    }

    public static void main(String[] args) {
        System.out.println(calcDoubleFactorial(7));
    }
}
