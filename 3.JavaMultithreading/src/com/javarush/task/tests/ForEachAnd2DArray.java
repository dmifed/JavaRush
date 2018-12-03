package com.javarush.task.tests;

/**
 * Created by DIMA on 10.05.2018.
 */
public class ForEachAnd2DArray {
    public static void main(String[] args) {
        int[][]arr = new int[4][4];
        int k = 0;
        for(int[] ii : arr){
            for (int i : ii){
                i = ++k;
            }
        }
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
