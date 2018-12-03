package com.javarush.task.tests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DIMA on 24.01.2018.
 */
public class TestRecursion {
    List<String> names;
    List<List<String>> allLists;


    public TestRecursion(){
        names = new ArrayList<>();
        allLists = new ArrayList<>();
    }

    public static void main(String[] args) {
        TestRecursion t = new TestRecursion();
        List<String> names = t.names;
        List<List<String>> allLists = t.allLists;
        names.add("Jack");
        names.add("Kate");
        names.add("Mark");
        //names.add("Sara");
        //names.add("Yoyo");
        //names.add("Zuzu");
        allLists.add(new ArrayList<>(names));
        //t.methodRecursion(names);
        t.createSetsOfVideos(names);
        System.out.println(allLists);
    }
    void methodRecursion(List<String> n){
        System.out.println("Recursion calling " + n + " " + n.size());

        for(int i = n.size()-1; i>=1; i--){
            n = n.subList(0, i);
            if(!allLists.contains(n) && n.size() !=0 ){
                System.out.println("add");
                allLists.add(new ArrayList<>(n));
                //continue;
            }
            methodRecursion(n);
        }

    }

    void createSetsOfVideos(List<String> sourse){
        List<String> sourseReserv = new ArrayList<>(sourse);
        for(int i = sourse.size()-1; i>=0; i--){
            sourse.remove(i);
            if(!allLists.contains(sourse) && sourse.size()>0){
                allLists.add(new ArrayList<>(sourse));
            }
            createSetsOfVideos(sourse);
            sourse = new ArrayList<>(sourseReserv);
        }
    }
}
