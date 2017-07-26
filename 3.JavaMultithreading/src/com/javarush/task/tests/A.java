package com.javarush.task.tests;

/**
 * Created by dima on 25.05.2017.
 */
public class A {
    @Override
    public String toString() {
        return "toString A{}";
    }
    public A(){
        System.out.println("constructor A");
    }
    static {
        System.out.println("static A");
    }
    {
        System.out.println("{}A");
    }
}
