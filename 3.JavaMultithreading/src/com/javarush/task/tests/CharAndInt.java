package com.javarush.task.tests;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.SortedMap;

/**
 * Created by dima on 26.04.2017.
 */
public class CharAndInt {
    public static void main(String[] args) {
        char c = 'A';
        c++;
        System.out.println(c);

        SortedMap<String, Charset> charsetSortedMap = Charset.availableCharsets();
        for(Map.Entry<String, Charset> entry : charsetSortedMap.entrySet()){
            System.out.println(entry.getKey() + "   " + entry.getValue());
        }
        System.out.println(Charset.defaultCharset());
    }

}
