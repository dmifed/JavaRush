package com.javarush.task.tests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DIMA on 22.01.2018.
 */
public class TestEqualsList {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list1.add("Mari");
        list1.add("Jack");
        list2.add("Jack");
        list2.add("Mari");
        System.out.println(list1.equals(list2));

    }
}
