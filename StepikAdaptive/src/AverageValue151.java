import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by DIMA, on 24.07.2018
 */
public class AverageValue151 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int a;
        while ((a = scanner.nextInt()) != 0){
            list.add(a);
        }
        scanner.close();
        double average = list.stream().mapToInt(s -> s).average().orElse(0);
        System.out.println(average);
    }
}
