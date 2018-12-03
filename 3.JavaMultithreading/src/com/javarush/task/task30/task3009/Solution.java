package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number){
        Set<Integer> integerSet = new HashSet<>();
        int n;
        try{
            n = Integer.valueOf(number); //NumberFormatException
            String stringInSystem = "";
            for(int i = 2; i <= 36; i++){
                stringInSystem = Integer.toString(n, i);
                //check polindrom
                boolean isPolindrom = true;
                int lenOfNumber = stringInSystem.length();
                for (int j = 0; j<lenOfNumber/2; j++){
                    if(stringInSystem.charAt(j) != stringInSystem.charAt(lenOfNumber-j-1)){
                        isPolindrom = false;
                        break;
                    }
                }
                if(isPolindrom){
                    integerSet.add(i);
                }
            }
        }catch (NumberFormatException e){
        }


        return integerSet;
    }
}