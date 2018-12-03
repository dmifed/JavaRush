package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by DIMA on 07.02.2018.
 */
public class DirectorTablet {
    public void printAdvertisementProfit(){
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<Date, Long> dateLongMap = statisticManager.calculateProfitForDays();
        double totalAmountRub = 0;
        for(Map.Entry<Date, Long> entry : dateLongMap.entrySet()){
            Date d = entry.getKey();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH);
            double amount = ((double)entry.getValue())/100;
            totalAmountRub = totalAmountRub + amount;
            //14-May-2013 - 2.50
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", simpleDateFormat.format(d), amount));
        }
        //Total - 547.50
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", totalAmountRub));
        ConsoleHelper.writeMessage("");
    }
    public void printCookWorkloading(){
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<Date, Map<String, Integer>> mapDateMapStringInteger = statisticManager.calculateTimeForPerCookPerDays();
        for(Map.Entry<Date, Map<String, Integer>> entry : mapDateMapStringInteger.entrySet()){
            Date d = entry.getKey();
            Map<String, Integer> stringIntegerMap = entry.getValue();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH);
            ConsoleHelper.writeMessage(simpleDateFormat.format(d));
            //14-May-2013
            //Ivanov - 60 min
            //Petrov - 35 min
            for(Map.Entry<String, Integer> entryInnerMap : stringIntegerMap.entrySet()){
                String name = entryInnerMap.getKey();
                float time = entryInnerMap.getValue();
                int timeInMins = (int)Math.ceil(time/60);
                ConsoleHelper.writeMessage(name + " - " + timeInMins + " min");
            }
            ConsoleHelper.writeMessage("");
        }
    }
    public void printActiveVideoSet(){
        StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();
        List<Advertisement> advertisementList = statisticAdvertisementManager.getActiveVideoList();
        for(Advertisement ad : advertisementList){
            ConsoleHelper.writeMessage(ad.getName() + " - " + ad.getHits());
        }
    }
    public void printArchivedVideoSet(){
        StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();
        List<Advertisement> advertisementList = statisticAdvertisementManager.getNotActiveVideoList();
        for(Advertisement ad : advertisementList){
            ConsoleHelper.writeMessage(ad.getName());
        }
    }
}
