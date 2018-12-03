package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
        //reader = new StringReader(null);
        //System.out.println(decode(reader, -3));
    }

    public static String decode(StringReader reader, int key) throws IOException {

        StringBuilder sb = new StringBuilder();
        sb.append("");
        if(reader == null){
            return sb.toString();
        }
        int b;
        while ((b = reader.read()) != -1){
            sb.append((char)(b+key));
        }
        StringWriter stringWriter = new StringWriter();
        stringWriter.write(sb.toString());


        return stringWriter.toString();
    }
}
