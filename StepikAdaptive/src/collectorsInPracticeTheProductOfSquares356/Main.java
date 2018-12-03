package collectorsInPracticeTheProductOfSquares356;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by DIMA on 09.07.2018.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(-5);
        numbers.add(0);
        long val = numbers.stream().collect(Collectors.mapping(t -> t*t, Collectors.reducing((a1, a2) -> a1*a2))).orElse(0);
        System.out.println(val);

    }
}
