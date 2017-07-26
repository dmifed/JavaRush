package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception{
        PrintStream console = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        testString.printSomething();
        String contextAdv = "JavaRush - курсы Java онлайн";
        String text = byteArrayOutputStream.toString();
        String[] textLines = text.split("\n");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < textLines.length; i++){
            if(i>0 && i%2 == 0){
                stringBuilder.append(contextAdv);
                stringBuilder.append("\n");
                stringBuilder.append(textLines[i]);

            }else {
                stringBuilder.append(textLines[i]);

            }
            if(i<textLines.length-1){
                stringBuilder.append("\n");
            }

        }

        //переделываем строку



        System.setOut(console);
        System.out.println(stringBuilder.toString());


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
