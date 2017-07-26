package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader file1Reader = new BufferedReader(new FileReader(fileName1));
        ArrayList<String> linesFile1 = new ArrayList<>();
        while (file1Reader.ready()){
            linesFile1.add(file1Reader.readLine());
        }
        file1Reader.close();

        BufferedReader file2Reader = new BufferedReader(new FileReader(fileName2));
        ArrayList<String> linesFile2 = new ArrayList<>();
        while (file2Reader.ready()){
            linesFile2.add(file2Reader.readLine());
        }
        file2Reader.close();
        int i = 0;
        int j = 0;
        int maxJ = linesFile2.size();
        int maxI = linesFile1.size();
        int max = Integer.max(maxI, maxJ);

        for(int k = 0; k<max; k++){
            if(linesFile1.get(i).equals(linesFile2.get(j))){
                // same
                lines.add(new LineItem(Type.SAME, linesFile1.get(i)));
                i++;
                j++;
            }else{
                if(linesFile2.contains(linesFile1.get(i))){
                    // add
                    lines.add(new LineItem(Type.ADDED, linesFile2.get(j)));
                    j++;
                }else{
                    // remove
                    lines.add(new LineItem(Type.REMOVED, linesFile1.get(i)));
                    i++;
                }
            }
        }
        if (i<maxI){
            for(int g = i; g<maxJ; g++){
                lines.add(new LineItem(Type.REMOVED, linesFile1.get(g)));
            }
        }
        if (j<maxJ){
            for(int g = j; g<maxJ; g++){
                lines.add(new LineItem(Type.ADDED, linesFile2.get(g)));
            }
        }


        // print lines
        for(int h = 0; h<lines.size(); h++){
            System.out.println(lines.get(h).type + " " + lines.get(h).line);
        }



    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
