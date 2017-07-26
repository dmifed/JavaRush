package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.TreeSet;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        TreeSet<Long> lstArmstrong = new TreeSet<>();
        long[][] matrix = Solution.calcMatrix(11);

        for(int k =1; k<N; k++){
            // если число не уникальное то берем следующее
            if (!Solution.checking(k)){                continue;            }

            //вычисляем разрядность числа
            int number = k;
            int maxPow = 0;
            int result = number;
            while(result != 0){
                result = result/10;
                maxPow++;
            }
            //считаем сумму степенней числа и числа с нулями
            result = number;
            double summa = 0;
            for(int i = 0; i<maxPow; i++){
                int ostatok = result%10;
                result = result/10;
                long adding = ostatok;
                if (adding !=0){
                    adding = matrix[ostatok-1][maxPow-1];
                }
                summa = summa + adding;
            }


            //смотрим равна ли сумма самой себе
            long number2 = (long)summa;
            int maxPow2 = 0;
            long result2 = number2;
            while(result2 != 0){
                result2 = result2/10;
                maxPow2++;
            }
            //считаем сумму степенней числа
            result2 = number2;
            double summa2 = 0;
            for(int i = 0; i<maxPow2; i++){
                long ostatokTmp = result2%10;
                int ostatok2 = (int) ostatokTmp;
                result2 = result2/10;
                long adding = ostatok2;
                if (adding !=0){
                    adding = matrix[ostatok2-1][maxPow2-1];
                }
                summa2 = summa2 + adding;
            }
            if(summa2 == number2 && summa2<N){
                lstArmstrong.add(number2);
            }
        }
        ArrayList<Long> lstNew = new ArrayList<>(lstArmstrong);

        long[] result = new long[lstNew.size()];
        for (int i = 0; i<result.length; i++){
            result[i] = lstNew.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        long memoryStart = Runtime.getRuntime().freeMemory();

        long start = System.currentTimeMillis();
        long[] arr = Solution.getNumbers(Integer.MAX_VALUE);
        for(long i : arr){
            System.out.println(i);
        }
        //System.out.println(memoryStart - Runtime.getRuntime().freeMemory());
        System.out.println(System.currentTimeMillis()-start + " ms");


    }
    public static boolean checking(long num){
        long ostatokCurrent = 0;
        long ostatokOld = 0;
        long result = num;
        int countLastZeros = 0;
        int increment = 0;
        while(result != 0){
            increment++;
            ostatokOld = result%10;
            if (ostatokOld == 0 && increment==1) {
                countLastZeros++;
            }
            result = result/10;
            ostatokCurrent = result%10;
            if (ostatokCurrent>ostatokOld && countLastZeros == 0){
                return false;
            }
        }
        return true;
    }

    public static long[][] calcMatrix(int pow){
        long [][] matrix = new long[10][pow];
        for(int i = 1; i<10; i++){
            for (int j = 1; j<=pow; j++){
                matrix[i-1][j-1] = (long)Math.pow(i,j);
            }
        }
        return matrix;
    }

}
