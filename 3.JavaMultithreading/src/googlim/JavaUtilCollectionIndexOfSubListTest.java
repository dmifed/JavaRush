package googlim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by DIMA on 01.11.2017.
 */
public class JavaUtilCollectionIndexOfSubListTest {

    public static void main(String[] args) {
        List<String> source = new ArrayList<>();
        List<String> target = new ArrayList<>();

        source.add("A");
        source.add("B");
        source.add("C");
        source.add("B");
        source.add("C");

        target.add("B");
        target.add("C");
        //target.add("D");


        System.out.println(Collections.indexOfSubList(source, target));
        System.out.println(Collections.lastIndexOfSubList(source, target));
    }

}
