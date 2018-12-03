package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        try{
            String s = args[0];
            //String s = "3";
            //
            //check A-Za-z0-9
            if(!s.matches("[A-Za-z0-9]+")){
                System.out.println("incorrect");
            }else {
                //to uppercase
                s = s.toUpperCase();
                //get max letter
                int maxLetter = 0;
                for(int i = 0; i<s.length(); i++){
                    if(s.charAt(i)>maxLetter){
                        maxLetter = s.charAt(i);
                    }
                }
                //calc min system of counting
                //if max letter a digit -- return max letter (min digit = 2)
                //System.out.println("maxLetter = " + maxLetter);
                if(maxLetter<=49){
                    System.out.println("2");
                }else if(maxLetter<=57){
                    System.out.println(String.valueOf(maxLetter-47));

                }else {
                    //else return maxLetter.toChar - 44
                    System.out.println(String.valueOf(maxLetter-54));
                }
            }
        }catch (Exception e){}
    }
}