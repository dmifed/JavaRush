package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import javafx.collections.transformation.SortedList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        TreeMap<String, Double> tabl = new TreeMap<String, Double>();
        String fileName = args[0];
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            String nameKey = line.split(" ")[0];
            double salary = Double.parseDouble(line.split(" ")[1]);
            if(tabl.containsKey(nameKey)){
                double s = tabl.get(nameKey) + salary;
                tabl.put(nameKey, s);
            }else {
                tabl.put(nameKey, salary);
            }
        }
        bufferedReader.close();
        ArrayList<Double> salaryList = new ArrayList<Double>(tabl.values());
        Collections.sort(salaryList);
        double maxSalary = salaryList.get(salaryList.size()-1);
        for(Map.Entry<String, Double> entry : tabl.entrySet()){
            if(entry.getValue()==maxSalary){
                System.out.println(entry.getKey());
            }
        }
    }
}
