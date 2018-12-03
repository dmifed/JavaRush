import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by DIMA, on 02.10.2018
 */
public class LuckyTicket154 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> tiketNumber = Arrays.stream(scanner.nextLine().split("")).map(Integer::parseInt).collect(Collectors.toList());
        int sumLeft = tiketNumber.subList(0,3).stream().reduce((s1, s2) -> s1+s2).orElse(0);
        int sumRight = tiketNumber.subList(3,6).stream().reduce((s1, s2) -> s1+s2).orElse(0);
        if(sumLeft == sumRight){
            System.out.println("Lucky");
        }else {
            System.out.println("Regular");
        }
    }
}
