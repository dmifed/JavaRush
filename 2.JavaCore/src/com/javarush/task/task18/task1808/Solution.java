package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fileName1 = "", fileName2 = "", fileName3 = "";
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
            fileName3 = reader.readLine();
            FileInputStream fileInputStream1 = new FileInputStream(fileName1);
            FileOutputStream fileOutputStream2 = new FileOutputStream(fileName2);
            FileOutputStream fileOutputStream3 = new FileOutputStream(fileName3);
            byte[] bytes = new byte[fileInputStream1.available()];
            fileInputStream1.read(bytes);
            if (bytes.length%2 == 0){
                fileOutputStream2.write(bytes, 0, bytes.length/2);
                fileOutputStream3.write(bytes, bytes.length/2, bytes.length/2);
            }else{
                fileOutputStream2.write(bytes, 0, bytes.length/2+1);
                fileOutputStream3.write(bytes, bytes.length/2+1, bytes.length/2);
            }
            fileInputStream1.close();
            fileOutputStream2.close();
            fileOutputStream3.close();

        }catch (FileNotFoundException e1){}
        catch (IOException e2){}

    }
}
