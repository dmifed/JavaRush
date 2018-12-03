package com.javarush.task.tests;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.AdvertisementStorage;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;

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

    // Подобрать список видео из доступных, просмотр которых обеспечивает максимальную выгоду
    // 1 сумма денег, полученная от показов, должна быть максимальной из всех возможных вариантов
    // 2. общее время показа рекламных роликов НЕ должно превышать время приготовления блюд для текущего заказа;
    // 3. для одного заказа любой видео-ролик показывается не более одного раза;
    // 4. если существует несколько вариантов набора видео-роликов с одинаковой суммой денег, полученной от показов, то:
    // 4.1. выбрать тот вариант, у которого суммарное время максимальное;
    // 4.2. если суммарное время у этих вариантов одинаковое, то выбрать вариант с минимальным количеством роликов;
    // 5. количество показов у любого рекламного ролика из набора - положительное число.
    public void processVideos(){
        if(storage.list().isEmpty()){
            throw new NoVideoAvailableException();
        }
        List<Advertisement> allVideos = storage.list();
        List<List<Advertisement>> listOfSetsVideos = new ArrayList<>();
        listOfSetsVideos.add((allVideos));
        createSetsOfVideos(allVideos, listOfSetsVideos); //получаем все возможные наборы
        /*
        System.out.println("---------TEST START-----------");
        for(int i = 0; i< listOfSetsVideos.size(); i++){
            List<Advertisement> l = listOfSetsVideos.get(i);
            for(int j = 0; j < l.size(); j++){
                System.out.print(l.get(j).getName() + l.get(j).getAmountPerOneDisplaying() + ", ");
            }
            System.out.println();
        }
        System.out.println("--------TEST END----------");
        */

        //удаляем наборы с превышающим временем и hits < 1
        Iterator<List<Advertisement>> iterator = listOfSetsVideos.iterator();
        while (iterator.hasNext()){
            int time = 0;
            boolean haveHitsLessOne = false;
            List<Advertisement> advertisementList = iterator.next();
            for (int j = 0; j<advertisementList.size(); j++){
                time = time + advertisementList.get(j).getDuration();
                if(advertisementList.get(j).getHits() < 1){
                    haveHitsLessOne = true;
                }
            }
            //общее время показа рекламных роликов НЕ должно превышать время приготовления блюд для текущего заказа
            //количество показов у любого рекламного ролика из набора - положительное число
            if(time > timeSeconds || haveHitsLessOne){
                iterator.remove();
            }
        }
        //if(listOfSetsVideos.isEmpty()){            throw new NoVideoAvailableException();        }
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
        /*
        System.out.println("---------TEST2 START-----------");
        for(int i = 0; i< listOfSetsVideos.size(); i++){
            List<Advertisement> l = listOfSetsVideos.get(i);
            for(int j = 0; j < l.size(); j++){
                System.out.print(l.get(j).getName() + l.get(j).getAmountPerOneDisplaying() + ", ");
            }
            System.out.println();
        }
        System.out.println("--------TEST2 END----------");
        */
        List<Advertisement> theListOfVideos = listOfSetsVideos.get(listOfSetsVideos.size()-1);

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
        //First Video is displaying... 50, 277
        //First Video - название рекламного ролика
        //50 - стоимость показа одного рекламного ролика в копейках
        //277 - стоимость показа одной секунды рекламного ролика в тысячных частях копейки (равно 0.277 коп)
        for(int i = 0; i<theListOfVideos.size(); i++){
            Advertisement ad = theListOfVideos.get(i);
            ad.revalidate();
            ConsoleHelper.writeMessage(ad.getName() + " is displaying... " + ad.getAmountPerOneDisplaying() + ", "
                    + 1000*ad.getAmountPerOneDisplaying()/ad.getDuration());
            /*
            for(Advertisement a : storage.list()){
                if(a.equals(ad)){
                    a.revalidate();
                }
            }
            */
            //System.out.println(storage.list().get(0).getClass());

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
