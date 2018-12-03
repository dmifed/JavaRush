import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.LongStream;

/**
 * Created by DIMA, on 25.07.2018
 */
public class SumOfNumbersDdivisibleBy {
    private static long sumOfListItemsDevisionBy(long devision){
        Scanner scanner = new Scanner(System.in);
        int countNumbers = scanner.nextInt();
        return LongStream.generate(scanner::nextLong).limit(countNumbers).filter(x -> x%devision == 0).sum();
    }

    public static void main(String[] args) {
        System.out.println(sumOfListItemsDevisionBy(6));
    }
}
