package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String[] a = getTokens("level22.lesson13.task01", ".");
        for (String s : a){
            System.out.println(s);
        }

    }
    public static String [] getTokens(String query, String delimiter) {

        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        int size = tokenizer.countTokens();
        String[] arr = new String[size];
        int index = 0;
        while (tokenizer.hasMoreElements()){
            arr[index] = tokenizer.nextToken();
            index++;
        }
        return arr;
    }
}
