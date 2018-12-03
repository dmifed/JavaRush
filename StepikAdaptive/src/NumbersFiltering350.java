import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by DIMA, on 03.10.2018
 */
public class NumbersFiltering350 {

    static IntStream even = IntStream.of(10, 30, 80, 40, 20, 60);
    static IntStream odd = IntStream.of(31, 45, 35, 75, 55, 65);

    public static IntStream createFilteringStream(IntStream evenStream, IntStream oddStream) {
        return IntStream.concat(evenStream, oddStream).sorted().filter(x -> x % 5 == 0 && x % 3 == 0).skip(2);
        // write your stream here
    }

    public static void main(String[] args) {
        List<Integer> list = createFilteringStream(even, odd).boxed().collect(Collectors.toList());
        System.out.println(list);
    }
}
