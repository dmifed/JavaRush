import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by DIMA on 12.07.2018.
 */
public class CollectorsInPracticePartitioningWordsIntoGroups357 {
    public static void main(String[] args) {
        String[] words = {"aaaa", "aa", "a"};
        Map<Boolean, List<String>> palindromeOrNoMap =
                Arrays.stream(words)
                        .collect
                                (Collectors.
                                        partitioningBy
                                                (t -> t.equalsIgnoreCase(new StringBuilder(t).reverse().toString())));


        CollectorsInPracticePartitioningWordsIntoGroups357.printMap(palindromeOrNoMap);
    }


    static <K, V> void printMap(Map<K,V> map){
        for (Map.Entry<K,V> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
