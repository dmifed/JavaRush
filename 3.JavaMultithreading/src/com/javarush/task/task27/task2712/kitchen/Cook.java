package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Restaurant;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by DIMA on 18.01.2018.
 */
//Consumer, т.к. обрабатывает заказы
public class Cook extends Observable implements Runnable{
    // implements Observer
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    private String name;
    private boolean busy;
    public Cook(String name) {
        this.name = name;
        //setQueue(queue);
    }

    @Override
    public void run() {
        while (true){
            if(queue.isEmpty() || isBusy()){
                try {
                    Thread.sleep(10);
                }catch (InterruptedException e){}
            }else {
                Order order = queue.poll();
                if (order != null) {
                    startCookingOrder(order);
                }
            }
        }
        //thread.setDaemon(true);
        //thread.start();
    }

    public boolean isBusy() {        return busy;    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order){
        busy = true;
        CookedOrderEventDataRow cookedOrderEventDataRow =
                new CookedOrderEventDataRow("Tablet# " , name, order.getTotalCookingTime()*60, order.getDishes());
        StatisticManager.getInstance().register(cookedOrderEventDataRow);
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");
        try {
            Thread.sleep(order.getTotalCookingTime()*10);
        }catch (InterruptedException e){}
        busy = false;
    }

    //Start cooking - Your order: [Water] of Tablet{number=5}, cooking time 3min
    /*
    @Override
    public void update(Observable o, Object order) {
        Order order1 = (Order) order;
        CookedOrderEventDataRow cookedOrderEventDataRow =
                new CookedOrderEventDataRow("Tablet# " , name, order1.getTotalCookingTime()*60, order1.getDishes());
        StatisticManager.getInstance().register(cookedOrderEventDataRow);
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order1.getTotalCookingTime() + "min");
        setChanged();
        notifyObservers(order);

    }
    */
}
