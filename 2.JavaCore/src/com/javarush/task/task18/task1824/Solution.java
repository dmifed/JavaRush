package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            while(true){
                String fileName = reader.readLine();
                try{
                    FileInputStream fileInputStream = new FileInputStream(fileName);
                    fileInputStream.close();
                }catch (FileNotFoundException e1){
                    System.out.println(fileName);
                    reader.close();
                }
            }
        }
        catch (IOException e2){}
    }
}
