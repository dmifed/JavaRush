import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by DIMA, on 10.08.2018
 */
public class CollatzConjecture1146 {
    List<Integer> collatzList = new ArrayList<>();

    private void collatz(int number){
        collatzList.add(number);
        if(number == 1) return;
        if(number%2 == 0){
            collatz(number/2);
        }else {
            collatz(number*3 + 1);
        }
    }
    private String printList(List<Integer> list){
        return list.stream().map(String :: valueOf).collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        CollatzConjecture1146 c = new CollatzConjecture1146();
        Scanner scanner = new Scanner(System.in);
        c.collatz(scanner.nextInt());
        scanner.close();
        System.out.println(c.printList(c.collatzList));
    }

}
