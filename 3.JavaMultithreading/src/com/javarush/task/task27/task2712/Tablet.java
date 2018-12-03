package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Created by DIMA on 17.01.2018.
 */
//Планшет
public class Tablet{
    final int number; // номер планшета
    public static java.util.logging.Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public Tablet(int number) {
        this.number = number;
        //setQueue(queue);
    }

    // Создание заказа из выбранных блюд
    public void createOrder(){
        Order order = null;
        try {
            order = new Order(this);
            commonOrder(order);
            //return order;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            //return null;
        }
    }

    private void commonOrder(Order order) {
        //setChanged();
        if(!order.isEmpty()) {
            ConsoleHelper.writeMessage(order.toString());
            try{
                queue.put(order);
            }catch (InterruptedException e){}

            //setChanged();
            //notifyObservers(order);
            try {
                new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
            } catch (NoVideoAvailableException e){
                logger.log(Level.INFO, "No video is available for the order " + order);
                StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(order.getTotalCookingTime()*60));
            }
        }
    }

    public void createTestOrder(){
        TestOrder order = null;
        try {
            order = new TestOrder(this);
            commonOrder(order);
            //return order;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            //return null;
        }
    }
    //Tablet{number=5}
    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }

}
