package com.javarush.task.tests;

/**
 * Created by dima on 25.05.2017.
 */
public class TestAandB {
    public static void main(String[] args) {
        A a = new A(); // constructor A
        B b = new B(); // super constructor A, constructor B
        System.out.println();
        System.out.println(a); // override Object toString
        System.out.println(b); // super A toString
        System.out.println();
        System.out.println(a.hashCode()); // Object hashcode
        System.out.println(b.hashCode()); // override Object hashcode

    }

}
