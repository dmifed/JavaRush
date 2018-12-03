package com.javarush.task.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by DIMA on 30.01.2018.
 */
public class TestSortComparator {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1000);
        l.add(1011);
        l.add(1010);
        l.add(1001);
        l.add(999);
        Collections.sort(l, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println(l);
    }
}
