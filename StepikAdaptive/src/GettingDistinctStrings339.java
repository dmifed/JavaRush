import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by DIMA, on 08.10.2018
 */
public class GettingDistinctStrings339 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("A");
        Function<List<String>, List<String>> list = p -> p.stream().distinct().collect(Collectors.toList());
        List<String> list2 = list.apply(list1);
        System.out.println(list2);

    }
}
