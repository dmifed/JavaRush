package com.javarush.task.tests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DIMA on 26.01.2018.
 */
public class TestAddToList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("0");
        for(int i = 1; i<10; i++){
            String s = String.valueOf(i);
            list.add(s);
        }
        System.out.println(list);
    }
}
