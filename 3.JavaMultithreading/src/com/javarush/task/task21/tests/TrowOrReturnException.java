package com.javarush.task.task21.tests;

/**
 * Created by dima on 19.04.2017.
 */
public class TrowOrReturnException {
    public Exception returnEx(){
        System.out.println("method returnEx");
        return new Exception();
    }
    public Object throwEx() throws Exception{
        System.out.println("method trowEx");
        throw new Exception();
    }

    public static void main(String[] args) {
        TrowOrReturnException t = new TrowOrReturnException();
        try {
            t.returnEx();
        }catch (Exception e){
            System.out.println("cathc return Exception" + e);
        }
        System.out.println();
        try {
            t.throwEx();
        }catch (Exception e){
            System.out.println("cathc throw Exception " + e.getStackTrace());
        }
    }
}
