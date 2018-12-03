import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//import java.util.stream.Collectors;

/**
 * Created by DIMA, on 27.11.2018
 */
public class TreeSet316 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] sets = reader.readLine().split(";");

        Set<Integer> set1 = new TreeSet<>(Comparator.reverseOrder());
        set1.addAll(Arrays.stream(sets[0].split(" ")).map(Integer::parseInt).sorted(Comparator.reverseOrder()).collect(java.util.stream.Collectors.toList()));
        //your code(add elements to set1 from sets[0])

        Set<Integer> set2 = new TreeSet<>(Comparator.reverseOrder());
        set2.addAll(Arrays.stream(sets[1].split(" ")).map(Integer::parseInt).sorted(Comparator.reverseOrder()).collect(java.util.stream.Collectors.toList()));
        //your code(add elements to set2 from sets[1])

        Set<Integer> set3 = new TreeSet<>(Comparator.reverseOrder());
        set3.addAll(Arrays.stream(sets[2].split(" ")).map(Integer::parseInt).sorted(Comparator.reverseOrder()).collect(java.util.stream.Collectors.toList()));
        //your code(add elements to set3 from sets[2])

        Set<Integer> resultTreeSet = unionTreeLargeNumber(set1,set2,set3);
        String res = resultTreeSet.stream().map(String::valueOf).collect(java.util.stream.Collectors.joining("\n"));
        System.out.println(res);

        //print elements of resultTreeSet(using System.out.printLn()) below

    }

    public static TreeSet<Integer> unionTreeLargeNumber(Set<Integer> set1, Set<Integer> set2, Set<Integer> set3){
        TreeSet<Integer> resultSet = new TreeSet<>(Comparator.reverseOrder());
        resultSet.add(set1.iterator().next());
        resultSet.add(set2.iterator().next());
        resultSet.add(set3.iterator().next());
        return resultSet;
    }
}
