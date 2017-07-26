package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator{
    private Thread thread;
    @Override
    public void run() { // запуск таскманипулятора
        while (!thread.isInterrupted()) {
            try {
                Thread.sleep(0);
                System.out.println(thread.getName());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }

    }

    @Override
    public void start(String threadName) { // создается и запускается нить thread
        thread = new Thread(this, threadName);
        thread.start();
        //System.out.println("Run " + thread.getName() );
    }

    @Override
    public void stop() { // прерывание нить thread
        thread.interrupt();
        //System.out.println("Interrupt " + thread.getName() );
    }
}
