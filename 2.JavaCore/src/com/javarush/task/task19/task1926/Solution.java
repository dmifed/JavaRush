package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = fileNameReader.readLine();
        fileNameReader.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready()){
            String textLine = bufferedReader.readLine();
            char[] chars = textLine.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = chars.length-1; i>=0; i--){
                stringBuilder.append(chars[i]);
            }
            System.out.println(stringBuilder.toString());

        }

        bufferedReader.close();
    }
}
