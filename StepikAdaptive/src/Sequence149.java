import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by DIMA, on 06.11.2018
 */
public class Sequence149 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limit = scanner.nextInt();
        scanner.close();
        String res = IntStream.rangeClosed(1, limit)
                .flatMap(i -> IntStream.generate(() -> i).limit(i))
                .limit(limit)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(res);
    }
}
