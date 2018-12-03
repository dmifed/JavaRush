package com.javarush.task.task32.task3203;

import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

/*
Пишем стек-трейс
*/
public class Solution {
    public static void main(String[] args) {
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
        System.out.println(text);
    }


    //Реализуй логику метода getStackTrace, который в виде одной строки (одного объекта типа String)
    // должен возвращать весь стек-трейс переданного исключения.
    //Используй подходящий метод класса Throwable, который поможет записать стек-трейс в StringWriter.

    public static String getStackTrace(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        //StringReader stringReader = new StringReader(throwable.toString());
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);


        return stringWriter.toString();



        //return null;
    }
}