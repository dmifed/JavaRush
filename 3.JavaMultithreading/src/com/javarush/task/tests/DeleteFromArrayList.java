package com.javarush.task.tests;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by dima on 26.05.2017.
 */
public class DeleteFromArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(11);
        arr.add(20);
        arr.add(21);
        arr.add(22);

        Iterator<Integer> iter = arr.iterator();
        while (iter.hasNext()){
            int i = iter.next();
            if(i == 20 || i == 10){
                iter.remove();
            }
        }
        for(int a : arr){
            System.out.println(a);
        }
    }
}
