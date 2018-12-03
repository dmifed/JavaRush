package com.javarush.task.tests;

/**
 * Created by DIMA on 16.01.2018.
 */
public class TestEndsWithIgnoredCase {
    public static void main(String[] args) {
        String s = "frgg.Html";
        s = s.toLowerCase();
        System.out.println(s.endsWith(".html"));
    }
}
