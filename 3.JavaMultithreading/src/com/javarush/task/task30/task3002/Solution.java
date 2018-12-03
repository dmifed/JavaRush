package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        int n;
        if(s.startsWith("0x")){
            s = s.substring(2);
            n = Integer.parseInt(s, 16);
        }else if(s.startsWith("0b")){
            s = s.substring(2);
            n = Integer.parseInt(s, 2);
        }else if(s.startsWith("0")){
            s = s.substring(1);
            //System.out.println(s);
            n = Integer.parseInt(s, 8);
        }else {
            n = Integer.parseInt(s, 10);
        }
        return String.valueOf(n);
    }
}
