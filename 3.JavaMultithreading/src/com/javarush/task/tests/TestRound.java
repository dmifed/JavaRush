package com.javarush.task.tests;

/**
 * Created by DIMA on 07.02.2018.
 */
public class TestRound {
    public static void main(String[] args) {
        float a = 378;
        float d = a/60;
        double aCeil = Math.ceil(d);
        System.out.println(d + "   " + (int)aCeil);
    }
}
