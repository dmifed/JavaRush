import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by DIMA, on 28.11.2018
 */
public class HashSet313 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        List<Integer> helpList = getList();
        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.stream(strings).map(Integer::parseInt).collect(Collectors.toList()));
        set.addAll(helpList);
        //add elements from strings to set

        //add elements from helpList to set

        set = removeAllNumbersMoreThan10(set);
        set.forEach(System.out::println);
    }

    public static Set<Integer> removeAllNumbersMoreThan10(Set<Integer> set){
        //put your code here
        return new HashSet<>(set.stream().filter(i -> i <= 10).collect(Collectors.toList()));
    }

    public static List<Integer> getList(){
        List<Integer> l = new ArrayList<>();
        l.add(5);
        l.add(45);
        l.add(-2);
        return l;
    }
}
