package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        /*
        Integer[] ar = {1, 1, 2, 3, 4, 5};
        ar = sort(ar);
        for(int a : ar){
            System.out.println(a + " ");
        }
        */

    }

    public static Integer[] sort(Integer[] array) {
        int mediana;
        Arrays.sort(array);
        if (array.length % 2 == 0){
            mediana = (int)(array[(array.length - 1)/2] + array[(array.length + 1)/2])/2;
        }else {
            mediana = array[array.length/2];
        }

        Comparator<Integer> comparatorToMedian = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int distanceO1 = Math.abs(o1-mediana);
                int ditanceO2 = Math.abs(o2-mediana);
                return distanceO1 - ditanceO2;
            }
        };


        //implement logic here
        Arrays.sort(array, comparatorToMedian);
        return array;
    }
}
