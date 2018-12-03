package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

/**
 * Created by DIMA on 23.04.2018.
 */
public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }
    //5. Реализация метода run для Consumer:
    //5.1. Усыпи трэд на 0.45 секунды.
    //5.2. В бесконечном цикле забери элемент из очереди методом take и выведи в консоль "Processing item.toString()".
    @Override
    public void run() {
        try {
            Thread.sleep(450);
        }catch (InterruptedException e){Thread.currentThread().interrupt();}
        while (!Thread.currentThread().isInterrupted()){
            try {
                ShareItem item = queue.take();
                System.out.format("Processing %s\n", item.toString());
            }catch (InterruptedException e){Thread.currentThread().interrupt();}
        }


    }
}
