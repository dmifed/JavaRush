import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by DIMA, on 02.10.2018
 */
public class Replacement171 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = Arrays.stream(scanner.nextLine().trim().split(" +")).collect(Collectors.joining("_"));
        System.out.println(string);
    }
}
