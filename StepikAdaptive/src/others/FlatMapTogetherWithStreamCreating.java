package others;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by DIMA on 27.06.2018.
 */
public class FlatMapTogetherWithStreamCreating {
    public static void main(String[] args) {
        List<Integer> numbers = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());


        //generate infinity sequence
        // limit to stop sequence
        List<Integer> generated = numbers.stream()
                .flatMap(n -> Stream.generate(() -> n).limit(3))
                .collect(Collectors.toList());
        print(generated); //1 2 2 3 3 3 4 4 4 4 5 5 5 5 5


        //sequence from 1 to n both inclusive by step 1
        generated = numbers.stream()
                .flatMapToInt(n -> IntStream.rangeClosed(1, n))
                .boxed()
                .collect(Collectors.toList());

        print(generated); //1, 1, 2, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 4, 5
        // 1 -> 1+0 (limit 1);
        // 2 -> 2+0, 2 -> 2+1 (limit 2);
        // 3 -> 3+0, 3 -> 3+1; 3 -> (3 -> 3+1) + 1 (limit 3)
        // 4 -> 4+0, 4 -> 4+1, 4-> (4 -> 4+1) + 1, 4 -> (4-> (4 -> 4+1) + 1)( (limit 4)


        // val -> val + 1 is unaryOperator f
        // first elem = elem -> 1
        // second elem = f(elem) -> 1+1
        // current element continiusly apply to element, f(element), f(f(element)) n times
        // at each
        generated = numbers.stream()
                .flatMapToInt(n -> IntStream.iterate(n, val -> val + 1).limit(8))
                .boxed() // boxed primitive type to Link type (int -> Integer)
                .collect(Collectors.toList());

        print(generated); //1,  2, 3,  3, 4, 5,  4, 5, 6, 7,  5, 6, 7, 8, 9



    }

    static void print(List<Integer> l){
        for(int i : l){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
