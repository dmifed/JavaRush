import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by DIMA, on 01.10.2018
 */
public class SequenceReversal170 {
    public static void main(String[] args) {
        List<Integer> seq = new ArrayList<>();
        List<Integer> revesalSeq = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int sizeSeq = scanner.nextInt();
        for(int i = 0; i < sizeSeq; i++){
            seq.add(scanner.nextInt());
        }
        scanner.close();
        for(int i = 0; i < sizeSeq/2; i++){
            int elem = seq.get(i) + seq.get(sizeSeq - 1 - i);
            revesalSeq.add(elem);
        }
        if(sizeSeq % 2 != 0){
            revesalSeq.add(seq.get((sizeSeq/2)));
        }
        String s = revesalSeq.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(s);
    }
}
