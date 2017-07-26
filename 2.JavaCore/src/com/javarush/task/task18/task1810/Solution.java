package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String fileName;
            while (!(fileName = reader.readLine()).equals("")){
                FileInputStream fileInputStream = new FileInputStream(fileName);
                int count = fileInputStream.available();
                fileInputStream.close();
                if (count<1000){
                    throw new DownloadException();
                }
            }
        }catch (IOException e){}

    }

    public static class DownloadException extends Exception {

    }
}
