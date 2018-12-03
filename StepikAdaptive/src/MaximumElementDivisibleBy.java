import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by DIMA, on 25.07.2018
 */
public class MaximumElementDivisibleBy {
    private List<Integer> getList(){
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int countElem = scanner.nextInt();
        for(int i = 0; i< countElem; i++){
            if(scanner.hasNext()){
                list.add(scanner.nextInt());
            }else {
                break;
            }
        }
        scanner.close();
        return list;
    }

    private int getMaxElemDivisionBy(List<Integer> list, int division){
        return list.stream().filter(x -> x%division == 0).max(Comparator.naturalOrder()).orElse(0);
    }

    public static void main(String[] args) {
        MaximumElementDivisibleBy m = new MaximumElementDivisibleBy();

        System.out.println(m.getMaxElemDivisionBy(m.getList(), 4));
    }
}
