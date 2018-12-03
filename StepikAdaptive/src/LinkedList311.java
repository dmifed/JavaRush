import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//import java.util.Comparator;
import java.util.LinkedList;
//import java.util.stream.Collectors;

/**
 * Created by DIMA, on 28.11.2018
 */
public class LinkedList311 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        LinkedList<Integer> ll = new LinkedList<>();
        java.util.Arrays.stream(str.split(" ")).map(Integer::parseInt).forEach(i -> ll.addFirst(i));
        ll.remove(0);
        ll.remove(0);
        ll.remove(0);
        String s = ll.stream().sorted(java.util.Comparator.naturalOrder()).map(String::valueOf).collect(java.util.stream.Collectors.joining("\n"));
        System.out.println(s);
        //your code


    }
}
