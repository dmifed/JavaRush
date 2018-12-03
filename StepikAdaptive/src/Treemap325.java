import java.util.*;

/**
 * Created by DIMA, on 14.08.2018
 */
public class Treemap325 {
    private static TreeMap<Integer, String> getTreeMap(){
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\n");
        String[] entries = scanner.next().split(" ");
        scanner.close();
        TreeMap<Integer, String> map = new TreeMap<>();
        for(String entry : entries){
            int key = Integer.parseInt(entry.split(":")[0]);
            String value = entry.split(":")[1];
            map.put(key, value);
        }
        return map;
    }

    private static NavigableMap<Integer, String> getSubMap(NavigableMap<Integer, String> map){
        int key = map.firstKey();
        NavigableMap<Integer, String> subMap;
        List<Integer> keyList = new ArrayList<>(map.keySet());
        if(key%2 != 0){
            // from First Key inclusive to FirstKey+4 inclusive
            subMap = map.subMap(keyList.get(0), true, keyList.get(0)+4, true);
        }else {
            //from LastKey-4 inclusive to the Last Key inclusive
            subMap = map.subMap(keyList.get(keyList.size()-1)-4, true, keyList.get(keyList.size()-1), true);
        }
        return subMap.descendingMap();
    }

    private static void printMap(Map<Integer, String> map){
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.printf("%d : %s", entry.getKey(), entry.getValue());
            System.out.println();
        }
    }



    public static void main(String[] args) {
        printMap(getSubMap(getTreeMap()));
    }
}
