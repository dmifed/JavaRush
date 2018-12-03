package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("E:\\JavaRushTests\\test32level\\long.txt"));
        System.out.println(writer.toString());
    }

    //Реализуй логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из переданного потока.
    //Возвращаемый объект ни при каких условиях не должен быть null.

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter stringWriter = new StringWriter();
        if(is == null){
            return stringWriter;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(is);
        char[] bufer = new char[1024];
        int len;
        while ((len = inputStreamReader.read(bufer)) > 0){
            stringWriter.write(bufer, 0, len);
        }
        inputStreamReader.close();
        return stringWriter;

    }
}