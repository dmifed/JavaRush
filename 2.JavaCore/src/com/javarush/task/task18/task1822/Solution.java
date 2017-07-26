package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader2 = new BufferedReader(fileReader);
        String line;
        while ((line = reader2.readLine())!= null){
            if (line.startsWith(args[0] + " ")){
                System.out.println(line);
                //break;
            }
        }
        reader.close();
        fileReader.close();
        reader2.close();

    }
}
