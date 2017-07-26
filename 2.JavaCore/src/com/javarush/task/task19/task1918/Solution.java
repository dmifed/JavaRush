package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        String keyStartTag = "<"+"span"; // "<"+args[0]
        String keyEndTag = "</"+"span"+">"; // "</"+args[0]+">"
        ArrayList<Integer> startIndexes = new ArrayList<>();
        ArrayList<Integer> endIndexes = new ArrayList<>();
        String test = "Info <span>about Leela <span xml:lang=»en» lang=»en»><b><span>Turanga Leela</span></b></span><span>Super</span><span>girl</span></span>";
        int begin = 0;
        Solution s = new Solution();
        s.findIndex(test, keyStartTag, 0, startIndexes);
        s.findIndex(test, keyEndTag, 0, endIndexes);

        for(int i = 0; i<startIndexes.size(); i++){            System.out.print(startIndexes.get(i) + " ");        }
        System.out.println();
        for(int i = 0; i<endIndexes.size(); i++){            System.out.print(endIndexes.get(i) + " ");        }
        System.out.println();
        for (int i = 0; i<startIndexes.size(); i++){
            int index = startIndexes.get(i);
            int count = 0;
            for (int j=i+1; j<startIndexes.size(); j++){
                if (endIndexes.get(i)>startIndexes.get(j)){
                    count++;
                }else{
                    count--;
                }
            }
            int lastIndex = endIndexes.get(i+count) + keyEndTag.length();
            System.out.println(index + " " + (lastIndex-keyEndTag.length()));
            System.out.println(test.substring(index, lastIndex));
        }

    }
    private void findIndex(String sourceHtml, String strKey, int begin, ArrayList list){
        int index = sourceHtml.indexOf(strKey, begin);

        if (index != -1){
            list.add(index);
            begin = index+1;
            findIndex(sourceHtml, strKey, begin, list);
        }

    }
}
