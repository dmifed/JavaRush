package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        for(Thread t : threads){
            int state = t.getState().ordinal();
            switch (state){
                case 0: t.start();
                    break;
                case 1: t.isInterrupted();
                    break;
                case 2: t.interrupt();
                    break;
                case 3: t.interrupt();
                    break;
                case 4: t.interrupt();
                    break;
                case 5: System.out.println(t.getPriority());
                    break;
            }
        }
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {
    }
}
