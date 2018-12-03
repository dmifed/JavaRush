import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by DIMA, on 24.08.2018
 */
public class MaximumPairwiseProduct1120 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Long> list = new ArrayList<>();
        for(int i = 0; i < count; i++){
            list.add(scanner.nextLong());
        }
        scanner.close();
        Collections.sort(list);
        long maxPairwiseProduct = list.get(list.size()-1) * list.get(list.size()-2);
        System.out.println(maxPairwiseProduct);
    }
}
