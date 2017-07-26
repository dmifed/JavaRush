package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fileName1 = "", fileName2 = "";
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
            FileInputStream fileInputStream = new FileInputStream(fileName1);
            FileOutputStream fileOutputStream = new FileOutputStream(fileName2);
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            for (int i = bytes.length-1; i>=0; i--){
                fileOutputStream.write(bytes[i]);
            }
            fileInputStream.close();
            fileOutputStream.close();

        }catch (FileNotFoundException e1){}
        catch (IOException e2){}
    }
}
