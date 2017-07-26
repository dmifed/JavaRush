package com.javarush.task.task25.task2506;

/**
 * Created by DIMA on 30.06.2017.
 */
public class LoggingStateThread extends Thread {
    private Thread t;

    public LoggingStateThread(Thread t){
        this.t = t;
        //Thread.State s = t.getState();
        //System.out.println(s);
        //t.setDaemon(true);
    }

    @Override
    public void run() {
        Thread.State state = t.getState();
        System.out.println(state);
        while (true){
            Thread.State newState = t.getState();
            //System.out.println("tmp newstate " + newState);
            if(state != newState){
                System.out.println(newState);
                state = newState;
            }

            if(newState == State.TERMINATED){
                this.interrupt();
                return;
            }
            //try{                Thread.sleep(50);            }catch (InterruptedException e){}


        }


   }
}
