package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception {
        //for(String s : words){            System.out.println(s);        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName));
        int countWords = 0;
        while (bufferedReader1.ready()){
            String textLine = bufferedReader1.readLine();
            //System.out.println(textLine);
            String[] lineWords = textLine.split(" ");
            for (int i = 0; i<lineWords.length; i++){
                if (words.contains(lineWords[i])){
                    //System.out.println("eee");
                    countWords++;
                }
            }
            //System.out.println(countWords);
            if(countWords == 2){
                System.out.println(textLine);
            }
            countWords = 0;

        }
        bufferedReader1.close();

    }
}
