package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        String fileName;
        //implement this method - реализуйте этот метод
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream;
        try {
            fileName = bufferedReader.readLine();
            bufferedReader.close();
            fileInputStream = new FileInputStream(fileName);
            load(fileInputStream);
            fileInputStream.close();
        }catch (IOException e){} catch (Exception e2){}

    }

    public void save(OutputStream outputStream) throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        for(Map.Entry<String, String> entry : properties.entrySet()){
            String param = entry.getKey() + "=" + entry.getValue() + "\r\n";
            bufferedWriter.write(param);
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String[] line = bufferedReader.readLine().split("=");
        properties.put(line[0], line[1]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.fillInPropertiesMap();

    }
}
