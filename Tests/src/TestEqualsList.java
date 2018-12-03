import java.util.ArrayList;
import java.util.List;

/**
 * Created by DIMA, on 02.11.2018
 */
public class TestEqualsList {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<List<Integer>> big1 = new ArrayList<>();
        List<List<Integer>> big2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);

        list2.add(1);
        list2.add(2);

        big1.add(list1);
        big2.add(list2);
        System.out.println(big1.equals(big2));
    }
}
