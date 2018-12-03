import java.util.*;

/**
 * Created by DIMA, on 30.10.2018
 */
public class SymmetricDifferenceOfSets1139 {
    private static Set<String> set1 = new HashSet<>();
    private static Set<String> set2 = new HashSet<>();
    private static Set<String> set3 = new HashSet<>();
    private static Scanner scanner = new Scanner(System.in);

    private static void fillSet(Set<String> set){
        String[] items = scanner.nextLine().split(" ");
        set.addAll(Arrays.asList(items));
    }

    public static void main(String[] args) {
        fillSet(set1);
        fillSet(set2);
        scanner.close();
        set3.addAll(set1);
        set3.addAll(set2);
        Set<String> setRetain = new HashSet<>(set1);
        setRetain.retainAll(set2);
        set3.removeAll(setRetain);
        StringBuilder sb = new StringBuilder();
        for(String s : set3){
            sb.append(s).append(" ");
        }
        System.out.println(sb.toString());
    }

}
