import java.util.*;

/**
 * Created by DIMA, on 27.07.2018
 */
public class Sorting1102 {
    private static Map<Integer, Integer> getMap(){
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> integerIntegerMap = new TreeMap<>();
        int countKeys = scanner.nextInt();
        for (int i = 1; i <= countKeys; i++){
            integerIntegerMap.put(i, scanner.nextInt());
        }
        scanner.close();
        return integerIntegerMap;
    }

    private static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> sortByValues(Map<K,V> map){
        SortedSet<Map.Entry<K, V>> sortedEntryesSet = new TreeSet<>(new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                int res = o1.getValue().compareTo(o2.getValue());
                return res != 0 ? res : 1;
            }
        });
        sortedEntryesSet.addAll(map.entrySet());
        return sortedEntryesSet;
    }

    private static void printKeys(Set<Map.Entry<Integer, Integer>> map){
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, Integer> entry : map){
            sb.append(entry.getKey()).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) {
        printKeys(sortByValues(getMap()));
    }
}
