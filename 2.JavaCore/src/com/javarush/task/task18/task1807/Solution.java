package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fileName = "";
        int countComa = 0;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            fileName = reader.readLine();
        }catch (IOException e){}
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            while (fileInputStream.available()>0){
                if (fileInputStream.read() == 44){
                    countComa++;
                }
            }
            fileInputStream.close();
        }catch (FileNotFoundException e){}
        catch (IOException e){}
        System.out.println(countComa);




    }
}
