package com.javarush.task.tests;

/**
 * Created by DIMA on 08.05.2018.
 */
public class CompareInfinity {
    public static void main(String[] args) {
        double a = 10.0/0.0;
        double b = a + 1000.0;
        System.out.println(a==b);
    }
}
