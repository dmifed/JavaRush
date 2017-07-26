package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        String key = args[0];
        String fileNameSource = args[1];
        String fileNameCode = args[2];
        FileInputStream fileInputStream = new FileInputStream(fileNameSource);
        FileOutputStream fileOutputStream = new FileOutputStream(fileNameCode);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        if(args[0].equals("-e")){//encoding
            byte[] bytes2 = new byte[bytes.length];
            for(int i = 0; i<bytes.length; i++){
                bytes2[i] = bytes[bytes.length-i-1];
            }
            fileOutputStream.write(bytes2);

        }

        if(args[0].equals("-d")){//decoding
            byte[] bytes2 = new byte[bytes.length];
            for(int i = 0; i<bytes.length; i++){
                bytes2[i] = bytes[bytes.length-i-1];
            }
            fileOutputStream.write(bytes2);

        }

        fileInputStream.close();
        fileOutputStream.close();


    }

}
