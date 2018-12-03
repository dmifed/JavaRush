package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by DIMA on 17.01.2018.
 */
public class Restaurant {
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
    private static final int ORDER_CREATING_INTERVAL = 100;
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Cook cook1 = new Cook("AmigoIvanov");
        Cook cook2 = new Cook("IvanovAmigo");
        cook1.setQueue(orderQueue);
        cook2.setQueue(orderQueue);
        Waiter waiter = new Waiter();
        List<Tablet> tabletList = new ArrayList<>();
        Thread threadCook1 = new Thread(cook1);
        Thread threadCook2 = new Thread(cook2);
        threadCook1.start();
        threadCook2.start();
        //threadCook1.setDaemon(true);
        //threadCook2.setDaemon(true);


        StatisticManager statisticManager = StatisticManager.getInstance();
        //statisticManager.register(cook1);
        //statisticManager.register(cook2);
        cook1.addObserver(waiter);
        cook2.addObserver(waiter);
        //OrderManager orderManager = new OrderManager();
        for(int i = 0; i<5; i++){
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
            //tablet.addObserver(new OrderManager());
            tabletList.add(tablet);
            /*
            int toCook = (int)(1 + Math.random()*2);
            if(toCook == 1){
                tabletList.get(i).addObserver(cook1);
            }else {
                tabletList.get(i).addObserver(cook2);
            }
            */
        }
        RandomOrderGeneratorTask randomOrderGeneratorTask = new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL);
        Thread thread = new Thread(randomOrderGeneratorTask);
        thread.start();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){}
        thread.interrupt();
        /*
        // First order
        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Ivanov");
        tablet.addObserver(cook);
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        tablet.createTestOrder();
        // Second Order
        Tablet tablet2 = new Tablet(5);
        Cook cook2 = new Cook("Petrov");
        tablet2.addObserver(cook2);
        Waiter waiter2 = new Waiter();
        cook2.addObserver(waiter2);
        tablet2.createTestOrder();
        // Third order
        Tablet tablet3 = new Tablet(5);
        Cook cook3 = new Cook("Ivanov");
        tablet3.addObserver(cook3);
        Waiter waiter3 = new Waiter();
        cook3.addObserver(waiter3);
        tablet3.createTestOrder();
        // Fourth order
        Tablet tablet4 = new Tablet(5);
        Cook cook4 = new Cook("Ivanov");
        tablet4.addObserver(cook4);
        Waiter waiter4 = new Waiter();
        cook4.addObserver(waiter4);
        tablet4.createTestOrder();
        // Fifth order
        Tablet tablet5 = new Tablet(5);
        Cook cook5 = new Cook("Petrov");
        tablet5.addObserver(cook5);
        Waiter waiter5 = new Waiter();
        cook5.addObserver(waiter5);
        tablet5.createTestOrder();
        */
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }

}
