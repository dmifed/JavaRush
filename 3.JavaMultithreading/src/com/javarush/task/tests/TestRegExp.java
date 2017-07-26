package com.javarush.task.tests;

import java.lang.reflect.Method;

/**
 * Created by dima on 28.04.2017.
 */
public class TestRegExp {
    public static void main(String[] args) {
        String s = "a888";
        System.out.println(s.matches(".*[0-9]{3}"));
        System.out.println(s.split("\\D").length);
        Method[] methods = s.getClass().getMethods();
        for(Method m: methods){
            System.out.println(m.getName());
        }
    }
}
