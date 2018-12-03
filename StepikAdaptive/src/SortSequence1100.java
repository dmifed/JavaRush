import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by DIMA, on 24.08.2018
 */
public class SortSequence1100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lenSequence = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < lenSequence; i++){
            list.add(scanner.nextInt());
        }
        int k = scanner.nextInt();
        for(int i = 0; i < list.size(); i = i + k){
            if((i+k) > list.size()){
                k = list.size()%k;
            }
            List<Integer> l = list.subList(i,i+k);
            Collections.sort(l);
            for(int j = 0; j < k; j++){
                list.set(j+i, l.get(j));
            }
        }
        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
