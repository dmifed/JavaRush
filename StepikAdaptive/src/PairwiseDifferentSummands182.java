import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by DIMA, on 10.08.2018
 */
public class PairwiseDifferentSummands182 {
    private static List<Integer> getSummands(int number){
        int rest = 0;
        List<Integer> listSummands = new ArrayList<>();
        for(int i = 1; i <= number; i++){
            rest = number - i;{
                if(rest > i){
                    number = number - i;
                    listSummands.add(i);
                }else {
                    listSummands.add(number);
                    break;
                }
            }
        }
        return listSummands;
    }

    public static String printList(List<Integer> list){
        System.out.println(list.size());
        return list.stream().map(String ::valueOf).collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(printList(getSummands(scanner.nextInt())));

        scanner.close();
    }
}
