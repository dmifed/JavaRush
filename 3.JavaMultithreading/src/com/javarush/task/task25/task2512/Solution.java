package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        Throwable e1 = e.getCause();
        if (e1 != null){
            uncaughtException(t, e1);
        }
        System.out.println(e);
        t.interrupt();

    }

    public static void main(String[] args) throws Exception{

        Solution s = new Solution();
        s.uncaughtException(Thread.currentThread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));

    }
}
