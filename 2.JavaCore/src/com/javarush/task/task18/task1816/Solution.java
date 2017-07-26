package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        int countLetters = 0;
        FileInputStream fileInputStream;
        try{
            fileInputStream = new FileInputStream(args[0]);
            while (fileInputStream.available()>0){
                int letter = fileInputStream.read();
                if((letter >= 65 && letter <= 90) || (letter >= 97 && letter <= 122)){
                    countLetters++;
                }
            }
            System.out.println(countLetters);
            fileInputStream.close();
        }catch (FileNotFoundException e){}
        catch (IOException e2){}





    }
}
