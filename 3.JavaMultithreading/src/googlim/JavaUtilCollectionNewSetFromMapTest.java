package googlim;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by DIMA on 01.11.2017.
 */
public class JavaUtilCollectionNewSetFromMapTest {
    public static void main(String[] args) {
        TreeMap<String, Boolean> map = new TreeMap<>();
        //map.put("A", true);
        //map.put("B", true);
        //map.put("C", false);

        Set<String> set = Collections.newSetFromMap(map);

        map.put("A", true);
        map.put("B", true);
        map.put("C", false);

        for(String c : set){            System.out.print(c+ " ");        }
        System.out.println();

        set.add("D");

        for(String c : set){            System.out.print(c+ " ");        }
        System.out.println();

        map.put("New", true);
        map.put("NewNew", false);

        for(String c : set){            System.out.print(c+ " ");        }
        System.out.println();
    }
}
