package com.javarush.task.tests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DIMA on 30.01.2018.
 */
public class TestListRemove {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("A");
        l.add("B");
        l.add("C");
        l.add("D");
        l.add("E");
        l.add("F");

        for(int i = 0; i< l.size(); i++){
            if(l.get(i).equals("A") || l.get(i).equals("E")){
                l.remove(i);
            }
        }
        System.out.println(l);

    }
}
