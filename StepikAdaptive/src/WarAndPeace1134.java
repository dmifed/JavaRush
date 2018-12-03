
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by DIMA, on 22.08.2018
 */
public class WarAndPeace1134 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Stream.of(s.nextLine().toLowerCase().split(" "))
                .collect(Collectors.toMap(k -> k, v -> 1, (k1, k2) -> k1+1)).
                forEach((key,value) -> System.out.println(String.format("%s %d", key, value)));
        s.close();
    }
}
