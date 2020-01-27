package com.javarush.task.task27.task2712.ad;


import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.Comparator.comparing;

public class AdvertisementManager {
    private final Logger logger = Logger.getLogger(AdvertisementManager.class.getName());
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> videos = storage.list();
        if (videos.isEmpty()) {
            throw new NoVideoAvailableException();
        }
    }
}
