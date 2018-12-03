import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by DIMA, on 23.08.2018
 */
public class LineWithIntegers1117 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().trim();
        String[] arr = line.split(" +");
        List<String> strNum = Arrays.asList(arr);
        long sum = strNum.stream().map(Integer::parseInt).reduce((i1,i2) -> (i1+i2)).orElse(0);
        System.out.println(sum);


    }
}
