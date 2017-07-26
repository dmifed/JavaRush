package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        try{
            while (!(fileName = reader.readLine()).equals("exit")){
                ReadThread t = new ReadThread(fileName);
                t.start();
            }
            reader.close();
        }catch (IOException e){}
        //for(Map.Entry<String, Integer> entry : resultMap.entrySet()){System.out.println(entry.getKey() + " " + entry.getValue());}
    }

    public static class ReadThread extends Thread {
        //implement constructor body
        String fileName;
        byte[] bytes;
        public ReadThread(String fileName) {
            //System.out.println("Thread start");
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        // метод который читает файл

        @Override
        public void run() {
            try{
                FileInputStream fileInputStream = new FileInputStream(fileName);
                bytes = new byte[fileInputStream.available()];
                fileInputStream.read(bytes);
                fileInputStream.close();
                ArrayList<Byte> bytesList = new ArrayList<Byte>();
                ArrayList<Integer> bytesCount = new ArrayList<Integer>();
                for(int i = 0; i<bytes.length; i++){
                    if(bytesList.contains(bytes[i])){
                        int index = bytesList.indexOf(bytes[i]);
                        int count = bytesCount.get(index);
                        bytesCount.set(index, count+1);
                    }else{
                        bytesList.add(bytes[i]);
                        bytesCount.add(bytesList.size()-1, 1);
                    }
                }
                int maxCount = 0;
                for(int i = 0; i<bytesCount.size(); i++){
                    if(maxCount<bytesCount.get(i)){
                        maxCount = bytesCount.get(i);
                    }
                }
                byte maxByte = bytesList.get(bytesCount.indexOf(maxCount));
                resultMap.put(fileName, (int)maxByte);

            }catch (IOException e){}

        }
    }
}
