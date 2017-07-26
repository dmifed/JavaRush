package com.javarush.task.tests;

/**
 * Created by DIMA on 26.07.2017.
 */
public class PrintFalse {
    public static void main(String[] args) {
        byte b = 1;
        new PrintFalse().n(b,b);

    }
    void n(byte...args){        System.out.println("byte...args");    }//5

    void n(long...args){        System.out.println("long...args");    }//6

    void n(Byte b, Byte b2){        System.out.println("BYTE");    } //4

    void n(long b, long b2){        System.out.println("long");    } //3

    void n(Integer b, Integer b2){        System.out.println("INTEGER");    }//NOOOOOOOOO!

    void n(byte b, byte b2){        System.out.println("byte");    } //1

    void n (short b, short b2){        System.out.println("short");    } //2
}
