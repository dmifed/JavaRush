package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

/**
 * Created by DIMA on 23.04.2018.
 */
public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }
    //4. Реализация метода run для Producer:
    //4.1. Используя метод offer добавь в очередь 9 ShareItem-ов с такими параметрами:
    // ("ShareItem-N", N), где N - номер элемента от 1 до 9. public ShareItem(String description, int itemId)
    //4.2. Перед каждым добавлением выведи фразу "Элемент 'ShareItem-N' добавлен". Используй System.out.format.
    //4.3. Усыпи трэд на 0.1 секунды.
    //4.4. Если у очереди есть Consumer, не занятый работой, то выведи фразу "Consumer в ожидании!".
    //Просмотри методы интерфейса TransferQueue, там есть нужный метод.
    @Override
    public void run() {
        for(int i = 1; i<10; i++){
            if(Thread.currentThread().isInterrupted()){
                return;
            }
            String description = "ShareItem-"+i;
            ShareItem shareItem = new ShareItem(description, i);
            System.out.format("Элемент 'ShareItem-%d' добавлен\r\n", shareItem.getItemId());
            queue.offer(shareItem);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){}
            if(queue.hasWaitingConsumer()){
                System.out.format("Consumer в ожидании!\n");
            }
        }


    }
}
