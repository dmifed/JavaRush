import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by DIMA, on 27.11.2018
 */
public class List1116 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        IntStream.range(0, list.size()).filter(i -> i%2 == 1).map(list::get).forEach(System.out::println);
        int sum = list.stream().filter(i -> i%2 == 0).reduce((i1,i2) -> i1 + i2).orElse(0);
        System.out.println(sum);
    }
}
