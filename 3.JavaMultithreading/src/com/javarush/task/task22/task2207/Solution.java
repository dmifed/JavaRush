package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String fileName ="";
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));){
            fileName = bufferedReader.readLine();
        }catch (IOException e){
            System.out.println(e);
        }
        try(BufferedReader fileReader = new BufferedReader(new FileReader(fileName))){
            while (fileReader.ready()){
                sb.append(fileReader.readLine());
                sb.append(" ");
            }
        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (IOException e){
            System.out.println(e);
        }
        String[] nonRevers = sb.toString().split(" ");
        ArrayList<String> usedString = new ArrayList<>();
        for(int i = 0; i<nonRevers.length-1; i++){
            StringBuilder s = new StringBuilder(nonRevers[i]);
            StringBuilder sRevers = new StringBuilder(nonRevers[i]).reverse();
            StringBuilder s2 = new StringBuilder(nonRevers[i+1]);
            //System.out.println("comparing " + s + " and " + s2);
            if(sRevers.toString().equals(s2.toString()) && !usedString.contains(sRevers.toString()) && !usedString.contains(s.toString())){
                usedString.add(s.toString());
                usedString.add(sRevers.toString());
                Pair p = new Pair();
                p.first = s.toString();
                p.second = s2.toString();
                result.add(p);
                //i++;
            }
        }
        for(Pair p : result){            System.out.println(p);        }



    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
