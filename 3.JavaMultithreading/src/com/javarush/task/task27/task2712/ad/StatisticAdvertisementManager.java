package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by DIMA on 08.02.2018.
 */
public class StatisticAdvertisementManager {
    private StatisticAdvertisementManager(){}
    private static StatisticAdvertisementManager instance = new StatisticAdvertisementManager();
    public static StatisticAdvertisementManager getInstance(){        return instance;    }
    AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public List<Advertisement> getActiveVideoList(){
        List<Advertisement> allVideo = advertisementStorage.list();
        List<Advertisement> activeVideo = new ArrayList<>();
        for(Advertisement ad : allVideo){
            if(ad.getHits() >= 1){
                activeVideo.add(ad);
            }
        }
        activeVideo.sort(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });
        return activeVideo;
    }

    public List<Advertisement> getNotActiveVideoList(){
        List<Advertisement> allVideo = advertisementStorage.list();
        List<Advertisement> notActiveVideo = new ArrayList<>();
        for(Advertisement ad : allVideo){
            if(ad.getHits() == 0){
                notActiveVideo.add(ad);
            }
        }
        notActiveVideo.sort(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });
        return notActiveVideo;
    }

}
