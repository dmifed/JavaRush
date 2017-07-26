package com.javarush.task.tests;

/**
 * Created by DIMA on 17.07.2017.
 */
public class RegexpTest {
    public static void main(String[] args) {
        String s = "t-g";
        s = s.replaceAll(".", "\\*");
        System.out.println(s);
    }
}
