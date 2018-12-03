package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1){
                    try{
                        Thread.sleep(500);
                    }catch (InterruptedException e){}
                    synchronized (o2){
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        });

        t1.start();
        t2.start();
        Thread.sleep(2000);


        System.out.println(t1.getState());
        System.out.println(t2.getState());
        Thread.State state = t2.getState();
        return state != Thread.State.BLOCKED;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
