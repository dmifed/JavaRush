package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
        solution.createExpression(236);
        solution.createExpression(80);
        solution.createExpression(1234);
        solution.createExpression(2);
    }

    public void createExpression(int number) {
        String num = Integer.toString(number, 3);
        String[] strings = num.split("");
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for(String s : strings){
            integerArrayList.add(Integer.valueOf(s));
        }
        Collections.reverse(integerArrayList);
        for(int i = 0; i<integerArrayList.size()-1; i++){
            if(integerArrayList.get(i) == 2){
                integerArrayList.set(i, -1);
                integerArrayList.set(i+1, integerArrayList.get(i+1) + 1);
            }
        }
        for(int i = 0; i<integerArrayList.size()-1; i++){
            if(integerArrayList.get(i) == 3){
                integerArrayList.set(i, 0);
                integerArrayList.set(i+1, integerArrayList.get(i+1) + 1);
            }
        }
        if(integerArrayList.get(integerArrayList.size()-1) == 3){
            integerArrayList.set(integerArrayList.size()-1, 0);
            integerArrayList.add(1);
        }
        if(integerArrayList.get(integerArrayList.size()-1) == 2){
            integerArrayList.set(integerArrayList.size()-1, -1);
            integerArrayList.add(1);
        }

        for (int i = 0; i<integerArrayList.size(); i++){
            integerArrayList.set(i, (int)(integerArrayList.get(i)*Math.pow(3,i)));
        }
        String result = String.valueOf(number) + " =";
        for(int i : integerArrayList){
            if(i < 0){                result = result + " - " + i*-1;            }
            if(i>0){                result = result + " + " + i;            }
        }
        System.out.println(result);
        //напишите тут ваш код
    }
}