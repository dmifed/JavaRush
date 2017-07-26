package com.javarush.task.task21.tests;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by dima on 21.04.2017.
 */
public class ClassAndReflection {
    public static void main(String[] args) {
        Class[] interfaces = List.class.getInterfaces();
        for(Class a : interfaces){
            System.out.println(a);
        }
        System.out.println();
        System.out.println(String.class.getSuperclass());
        System.out.println();
        Method [] methods = List.class.getMethods();
        for(Method m : methods){
            System.out.println(m);
        }
        System.out.println();
        try {
            String s = String.class.newInstance();
            System.out.println(s);
            Method m = String.class.getMethod("length");
            System.out.println(m);
            int lenght = (int) m.invoke(s);
            System.out.println(lenght);
        }catch (Exception e){}

    }
}
