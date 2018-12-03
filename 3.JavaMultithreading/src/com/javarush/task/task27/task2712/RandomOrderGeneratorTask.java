package com.javarush.task.task27.task2712;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DIMA on 08.02.2018.
 */
//Producer, т.к. производит заказы
public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> listOfTablets;
    private int interval;
    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval){
        this.listOfTablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        //System.out.print(arr[(int)(Math.random()*arr.length)]);
        while (!Thread.currentThread().interrupted()){
            if (listOfTablets.isEmpty()) {
                return;
            }
            Tablet tablet = listOfTablets.get((int) (Math.random() * listOfTablets.size()));
            tablet.createTestOrder();
            try {
            Thread.sleep(interval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}
