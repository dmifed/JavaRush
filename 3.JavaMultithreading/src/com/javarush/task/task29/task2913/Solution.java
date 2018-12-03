package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;


    public static String getAllNumbersBetween(int a, int b){
        StringBuilder sb = new StringBuilder();
        if(a < b){
            sb.append(a);
            for(int i = a+1; i<=b; i++){                sb.append(" " + i);            }
        }else if(a > b){
            sb.append(a);
            for(int i = a-1; i>=b; i--){                sb.append(" " + i);            }
        }else {
            sb.append(a);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt() % 1_000;
        numberB = random.nextInt() % 10_000;
        //System.out.println(numberA + " " + numberB);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}