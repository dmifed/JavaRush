package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> lst = detectAllWords(crossword, "home", "same", "redf");
        for(int i = 0; i<lst.size(); i++){
            System.out.println(lst.get(i));
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> lst = new ArrayList<>();
        for(int i = 0; i<words.length; i++){ //берем по 1 слову из списка
            char[] arr = words[i].toCharArray();
            for(int row = 0; row<crossword.length; row++){
                for(int column = 0; column<crossword[row].length; column++){
                    if(crossword[row][column] == arr[0]){ // ищем совпадение первой буквы слова
                        //System.out.println("Yes, row = " + row + ", column = " + column);
                        int startX = column;
                        int startY = row;
                        int step = arr.length-1;
                        char lastLetter = arr[step];
                        //System.out.println("lastLetter is " + lastLetter);
                        for (int biasX = -1; biasX < 2; biasX++){
                            for(int biasY = -1; biasY <2; biasY++){
                                int endX = startX+step*biasX;
                                int endY = startY+step*biasY;
                                if(checkLastLetter(endX, endY, crossword, row, lastLetter)){
                                    if(checkAllWord(biasX, biasY, startX, startY, crossword, arr)){
                                        // слово совпало создать объект Word и положить в список lst
                                        Word w = new Word(words[i]);
                                        w.setStartPoint(startX, startY);
                                        w.setEndPoint(endX, endY);
                                        lst.add(w);
                                    }
                                }//else {System.out.println("checkLastLetter is " + lastLetter + "endX = " + endX + " endY = " + endY + " row = " + row);}
                            }
                        }


                    }
                }

            }
        }
        return lst;
    }
    public static boolean checkLastLetter(int endX, int endY, int[][] crossword, int row, char lastletter){
        if(endX>=0 && endX<crossword[row].length && endY>=0 && endY<crossword.length){
            return crossword[endY][endX] == lastletter;
        }
        return false;
    }
    public static boolean checkAllWord(int biasX, int biasY, int startX, int startY, int[][] crossword, char[] arr){
        for(int i = 0; i<arr.length; i++){
            char letter = arr[i];
            int letterInCrossword = crossword[startY + biasY*i] [startX + biasX*i];
            if (letter != letterInCrossword){
                return false;
            }
        }
        return true;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
