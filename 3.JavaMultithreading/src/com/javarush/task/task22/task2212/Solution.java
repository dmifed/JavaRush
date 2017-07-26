package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        //если номер начинается с ‘+‘, то он содержит 12 цифр
        if (telNumber.matches("^[\\+]{1}.*$")){
            if ( !telNumber.matches("^[\\+]{1}(\\d{1}\\D?){12}$")) return false;
        }
        //если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
        if (telNumber.matches("^[\\(|\\d]{1}.*$")){
            if ( !telNumber.matches("^[\\(]{1}(\\d{1}\\D?){10}$") && !telNumber.matches("^(\\d{1}\\D?){10}$")) return false;
        }
        return true;

    }
    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501334567"));
        System.out.println(checkTelNumber("+380(5)013-3-4567"));
        System.out.println(checkTelNumber(")0501334567"));

    }
}
