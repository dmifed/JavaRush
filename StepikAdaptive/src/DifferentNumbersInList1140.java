import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by DIMA, on 30.07.2018
 */
public class DifferentNumbersInList1140 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i< count; i++){
            set.add(scanner.nextInt());
        }
        scanner.close();
        System.out.println(set.size());
    }
}
