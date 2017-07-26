package com.javarush.task.tests;

/**
 * Created by dima on 25.05.2017.
 */
public class B extends A {
    @Override
    public int hashCode() {
        return 15;
    }

    public B(){
        System.out.println("constructor B");
    }

    {
        System.out.println("{} B");
    }
    static {
        System.out.println("static B");
    }
}
