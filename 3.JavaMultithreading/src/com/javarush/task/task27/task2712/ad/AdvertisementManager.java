package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 * Created by DIMA on 19.01.2018.
 */
//у каждого планшета будет свой объект менеджера, который будет подбирать оптимальный набор роликов и их последовательность для каждого заказа.
//Он также будет взаимодействовать с плеером и отображать ролики.
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos(){
        if(storage.list().isEmpty()){            throw new NoVideoAvailableException();        }

        List<Advertisement> allVideos = storage.list();
        List<List<Advertisement>> listOfSetsVideos = new ArrayList<>();
        listOfSetsVideos.add((allVideos));
        createSetsOfVideos(allVideos, listOfSetsVideos); //получаем все возможные наборы

        //удаляем наборы с превышающим временем и hits < 1
        Iterator<List<Advertisement>> iterator = listOfSetsVideos.iterator();
        while (iterator.hasNext()){
            int time = 0;
            boolean haveHitsLessOne = false;
            List<Advertisement> advertisementList = iterator.next();
            for (int j = 0; j<advertisementList.size(); j++){
                time = time + advertisementList.get(j).getDuration();
                if(advertisementList.get(j).getHits() <= 0){                    haveHitsLessOne = true;                }
            }
            if(time > timeSeconds || haveHitsLessOne){                iterator.remove();            }
        }
        //if(listOfSetsVideos.isEmpty()){            throw new NoVideoAvailableException();        }
        //сортировка всех наборов и выбор лучшего набора
        Collections.sort(listOfSetsVideos, new Comparator<List<Advertisement>>() {
            @Override
            public int compare(List<Advertisement> o1, List<Advertisement> o2) {
                //максимально по деньгам
                if(countMoney(o1) != countMoney(o2)){
                    return Long.compare(countMoney(o1), countMoney(o2));
                }else {
                    // по максимальному времени
                    if(countTime(o1) != countTime(o2)){
                        return Integer.compare(countTime(o1), countTime(o2));
                    }else {
                        // по минимальному количеству роликов
                        return Integer.compare(o2.size(), o1.size());
                    }
                }
            }
        });
        List<Advertisement> theListOfVideos = listOfSetsVideos.get(listOfSetsVideos.size()-1);

        // сортировка лучшего набора
        Collections.sort(theListOfVideos, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                //в порядке уменьшения стоимости показа одного рекламного ролика в копейках.
                int result = Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
                if(result != 0){
                    return result;
                }else {
                    //Вторичная сортировка - по увеличению стоимости показа одной секунды рекламного ролика в тысячных частях копейки.
                    long oneSecondAdvert1 = 1000*o1.getAmountPerOneDisplaying()/o1.getDuration();
                    long oneSecondAdvert2 = 1000*o2.getAmountPerOneDisplaying()/o2.getDuration();
                    return Long.compare(oneSecondAdvert1, oneSecondAdvert2);
                }
            }
        });
        int allDuration = 0;
        long allAmount = 0;
        for (Advertisement a : theListOfVideos){
            allDuration = allDuration + a.getDuration();
            allAmount = allAmount + a.getAmountPerOneDisplaying();
        }
        VideoSelectedEventDataRow videoSelectedEventDataRow = new VideoSelectedEventDataRow(theListOfVideos, allAmount, allDuration);
        StatisticManager.getInstance().register(videoSelectedEventDataRow);
        for(int i = 0; i<theListOfVideos.size(); i++){
            Advertisement ad = theListOfVideos.get(i);

            ad.revalidate();
            ConsoleHelper.writeMessage(ad.getName() + " is displaying... " + ad.getAmountPerOneDisplaying() + ", "
                                        + 1000*ad.getAmountPerOneDisplaying()/ad.getDuration());
        }
    }


    //мои вспомогательные методы
    private void createSetsOfVideos(List<Advertisement> sourse, List<List<Advertisement>> listOfSetsVideos){
        List<Advertisement> sourseReserve = new ArrayList<>(sourse);
        for(int i = sourse.size()-1; i>=0; i--){
            List<Advertisement> headList = sourse.subList(0,i);
            List<Advertisement> tailList = sourse.subList(i+1, sourse.size());
            List<Advertisement> trimList = new ArrayList<>(headList);
            trimList.addAll(tailList);

            if(!listOfSetsVideos.contains(trimList) && trimList.size()>0){
                listOfSetsVideos.add(new ArrayList<>(trimList));
            }
            createSetsOfVideos(trimList, listOfSetsVideos);
            sourse = new ArrayList<>(sourseReserve);
        }
    }
    private long countMoney(List<Advertisement> advertisementList){
        long countMoney = 0;
        for(int i = 0; i<advertisementList.size(); i++){
            countMoney = countMoney + advertisementList.get(i).getAmountPerOneDisplaying();
        }
        return countMoney;
    }
    private int countTime(List<Advertisement> advertisementList){
        int countTime = 0;
        for(int i = 0; i<advertisementList.size(); i++){
            countTime = countTime + advertisementList.get(i).getDuration();
        }
        return countTime;
    }
}
