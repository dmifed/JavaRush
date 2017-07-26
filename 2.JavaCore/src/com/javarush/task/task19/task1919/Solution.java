package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception{
        TreeMap<String, Double> tabl = new TreeMap<String, Double>();
        String fileName = args[0];
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            //System.out.println(line);
            String nameKey = line.split(" ")[0];
            double salary = Double.parseDouble(line.split(" ")[1]);
            if(tabl.containsKey(nameKey)){
                double s = tabl.get(nameKey) + salary;
                tabl.put(nameKey, s);
            }else{
                tabl.put(nameKey, salary);
            }
        }
        bufferedReader.close();

        for(Map.Entry<String, Double> entry : tabl.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
