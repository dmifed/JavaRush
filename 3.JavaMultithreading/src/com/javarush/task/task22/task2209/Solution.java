package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        String fileName = "";
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            fileName = bufferedReader.readLine();
        }catch (IOException e){}

        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            while (bufferedReader.ready()){
                stringBuilder.append(bufferedReader.readLine());
                stringBuilder.append(" ");
            }
        }catch (FileNotFoundException e){}
        catch (IOException e){}
        String[] cities = stringBuilder.toString().split(" ");
        //...
        StringBuilder result = getLine(cities);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if(words == null) return new StringBuilder();
        if (words.length == 1) return new StringBuilder(words[0]);
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i<words.length; i++){
            list.add(words[i]);
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        ArrayList<StringBuilder> allChains = new ArrayList<>();
        int maxLenOfChain = list.size();
        for(int i = 0; i<maxLenOfChain; i++){
            StringBuilder result = new StringBuilder();
            boolean[] isUsed = new boolean[list.size()];
            String first = list.get(i);
            result.append(first);
            result.append(" ");
            isUsed[i] = true;
            for(int j = 0; j<maxLenOfChain; j++){
                if(!isUsed[j]){
                    String lastLetter = result.toString().substring(result.length()-2, result.length()-1);
                    String firstLetter = list.get(j).substring(0,1);
                    if(lastLetter.equalsIgnoreCase(firstLetter)){
                        result.append(list.get(j));
                        result.append(" ");
                        isUsed[j] = true;
                        j = 0;
                    }
                    if(result.toString().split(" ").length== maxLenOfChain){
                        return result;
                    }else {
                        allChains.add(result);
                    }
                }
            }
        }
        StringBuilder maxChain = new StringBuilder();
        int maxLen = 0;
        for(int i = 0; i<allChains.size(); i++){
            int currentLen = allChains.get(i).toString().split("").length;
            if(currentLen > maxLen){
                maxLen = currentLen;
                maxChain = allChains.get(i);
            }
        }
        return new StringBuilder(maxChain.toString());
        //.substring(0, maxChain.toString().length()-1)
    }
}
