package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.*;

import java.util.*;

/**
 * Created by DIMA on 02.02.2018.
 */
public class StatisticManager {
    private StatisticStorage statisticStorage = new StatisticStorage();
    private static StatisticManager instance = new StatisticManager();
    private StatisticManager(){    }
    //private Set<Cook> cooks  = new HashSet<>();

    public static StatisticManager getInstance(){
        return instance;
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }
    //public void register(Cook cook){        cooks.add(cook);    }

    //public Set<Cook> getCooks() {        return cooks;    }

    //метод из хранилища достанет все данные,
    // относящиеся к отображению рекламы, и считает общую прибыль за каждый день.
    public Map<Date, Long> calculateProfitForDays(){
        long allProfitFromAd = 0;
        Map<Date, Long> mapOfAmountProfitPerDays = new TreeMap<>(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                Calendar c1 = new GregorianCalendar();
                c1.setTime(o1);
                Calendar c2 = new GregorianCalendar();
                c2.setTime(o2);
                return c2.compareTo(c1);

            }
        });
        Map<EventType, List<EventDataRow>> eventTypeListMap = statisticStorage.get();

        for(Map.Entry<EventType, List<EventDataRow>> entry : eventTypeListMap.entrySet()){
            EventType eventType = entry.getKey();
            if(eventType == EventType.SELECTED_VIDEOS){
                List<EventDataRow> eventList = entry.getValue();
                for(EventDataRow event : eventList){
                    VideoSelectedEventDataRow videoSelectedEventDataRow = (VideoSelectedEventDataRow) event;
                    Date date = videoSelectedEventDataRow.getDate();
                    date = timeToZero(date);
                    if (mapOfAmountProfitPerDays.containsKey(date)){
                        long amount = mapOfAmountProfitPerDays.get(date);
                        mapOfAmountProfitPerDays.put(date, amount + videoSelectedEventDataRow.getAmount());
                    }else {
                        mapOfAmountProfitPerDays.put(date, videoSelectedEventDataRow.getAmount());
                    }
                }
            }
        }
        return mapOfAmountProfitPerDays;
    }

    //метод из хранилища достанет все данные, относящиеся к работе повара,
    // и считает общую продолжительность работы для каждого повара отдельно.
    public Map<Date, Map<String, Integer>> calculateTimeForPerCookPerDays(){
        Map<Date, Map<String, Integer>> mapDateCookTime = new TreeMap<>(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                Calendar c1 = new GregorianCalendar();
                c1.setTime(o1);
                Calendar c2 = new GregorianCalendar();
                c2.setTime(o2);
                return c2.compareTo(c1);

            }
        });
        Map<EventType, List<EventDataRow>> eventTypeListMap = statisticStorage.get();
        for(Map.Entry<EventType, List<EventDataRow>> entry : eventTypeListMap.entrySet()){
            EventType eventType = entry.getKey();
            if(eventType == EventType.COOKED_ORDER){
                List<EventDataRow> eventList = entry.getValue();
                for(EventDataRow event : eventList){
                    CookedOrderEventDataRow cookedOrderEventDataRow = (CookedOrderEventDataRow) event;
                    Date date = cookedOrderEventDataRow.getDate();
                    // переделать вместо дат стринги
                    date = timeToZero(date);
                    if (mapDateCookTime.containsKey(date)){
                        Map<String, Integer> mapCookTime = mapDateCookTime.get(date);
                        if(mapCookTime.containsKey((cookedOrderEventDataRow.getCookName()))){
                            int allTimeSeconds = mapCookTime.get(cookedOrderEventDataRow.getCookName());
                            mapCookTime.put(cookedOrderEventDataRow.getCookName(), allTimeSeconds + cookedOrderEventDataRow.getTime());
                        }else {
                            mapCookTime.put(cookedOrderEventDataRow.getCookName(), cookedOrderEventDataRow.getTime());
                        }
                    }else {
                        Map<String, Integer> stringIntegerMap = new TreeMap<>(new Comparator<String>() {
                            @Override
                            public int compare(String o1, String o2) {
                                return o1.compareTo(o2);
                            }
                        });
                        stringIntegerMap.put(cookedOrderEventDataRow.getCookName(), cookedOrderEventDataRow.getTime());
                        mapDateCookTime.put(date, stringIntegerMap);
                    }
                }
            }
        }
        return mapDateCookTime;
    }

    private Date timeToZero(Date d){
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(d);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    private class StatisticStorage{
        Map<EventType, List<EventDataRow>> storage = new HashMap<>();
        public StatisticStorage(){

            for (EventType e : EventType.values()){
                storage.put(e, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data){
            List<EventDataRow> eventDataRowList = storage.get(data.getType());
            eventDataRowList.add(data);
        }

        private Map<EventType, List<EventDataRow>> get(){
            return storage;
        }
    }
}
