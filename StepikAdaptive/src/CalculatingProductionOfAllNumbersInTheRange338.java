import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by DIMA on 16.07.2018.
 */
public class CalculatingProductionOfAllNumbersInTheRange338 {

    public interface FuncInterface{
        long productAllNumbersInRange(long x, long y);
    }

      public static void main(String[] args) {
          CalculatingProductionOfAllNumbersInTheRange338.FuncInterface s =
                  ((long x1, long x2) -> LongStream.rangeClosed(x1,x2).reduce((a,b) -> a*b).orElse(x1));
          System.out.println(s.productAllNumbersInRange(1,4));

      }






}
