package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        String fileName = args[0];
        SortedMap<Byte, Integer> sortedMap = new TreeMap<Byte, Integer>();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        fileInputStream.close();
        for(int i = 0; i<bytes.length; i++){
            Integer freq = sortedMap.get(bytes[i]);
            //System.out.println(freq);
            if (!sortedMap.containsKey(bytes[i])){
                sortedMap.put(bytes[i], 1);
            }else{
                sortedMap.put(bytes[i], freq+1 );
            }
        }
        for(Map.Entry<Byte, Integer> entry: sortedMap.entrySet()){
            byte b = entry.getKey().byteValue();
            char c = (char)b;
            System.out.println(c + " " + entry.getValue());
        }

    }
}
