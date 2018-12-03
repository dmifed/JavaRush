import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by DIMA, on 22.08.2018
 */
public class List1118 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int targetNum = scanner.nextInt();
        scanner.nextLine();
        long count = Stream.of(scanner.nextLine().split(" ")).map(Integer::parseInt).filter(n -> n == targetNum).count();
        System.out.println(count);
    }


}
