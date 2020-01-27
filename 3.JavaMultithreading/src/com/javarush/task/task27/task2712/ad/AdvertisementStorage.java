package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static volatile AdvertisementStorage instance;
    private final ArrayList<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage() {
        Object someContent = new Object();
        new Advertisement(someContent, "First Video", 5000, 100, 3 * 60); // 3 min
        new Advertisement(someContent, "Second Video", 100, 10, 15 * 60); //15 min
        new Advertisement(someContent, "Third Video", 400, 2, 10 * 60); //10 min
    }

    public static AdvertisementStorage getInstance() {
        if (instance == null) {
            synchronized (AdvertisementStorage.class) {
                if (instance == null)
                    instance = new AdvertisementStorage();
            }
        }
        return instance;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }

    public List<Advertisement> list() {
        return videos;
    }
}
