package com.javarush.task.tests;

/**
 * Created by DIMA on 19.01.2018.
 */
public class ReturnFromTryCatch {
    public static void main(String[] args) {
        System.out.println(new ReturnFromTryCatch().trying());


    }
    public String trying(){
        try{
            //return "try";
            throw new Exception();
        }catch (Exception e){
            return "catch";
        }finally {
            return "finally";
        }
    }
}
