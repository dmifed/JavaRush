package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder stringBuilder = new StringBuilder();

        while (bufferedReader.ready()){
            String[] words = bufferedReader.readLine().split(" ");
            for (int i = 0; i<words.length; i++){
                if (words[i].length() > 6){
                    stringBuilder = stringBuilder.append(words[i]);
                    stringBuilder.append(",");
                }
            }
        }
        String textLine = stringBuilder.toString().substring(0, stringBuilder.toString().length()-1);
        bufferedWriter.write(textLine);
        bufferedReader.close();
        bufferedWriter.close();
    }
}
