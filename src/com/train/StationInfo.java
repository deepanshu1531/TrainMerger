package com.train;

import java.util.HashMap;
import java.util.Map;

public class StationInfo {
    public static final Map<String, Integer> stationDistance = new HashMap<>();

    static {
        stationDistance.put("CHN", 0);
        stationDistance.put("SLM", 350);
        stationDistance.put("BLR", 550);
        stationDistance.put("KRN", 900);
        stationDistance.put("HYB", 1200);
        stationDistance.put("NGP", 1600);
        stationDistance.put("ITJ", 1900);
        stationDistance.put("BPL", 2000);
        stationDistance.put("AGA", 2500);
        stationDistance.put("NDL", 2700);
        stationDistance.put("TVC", 0);
        stationDistance.put("SRR", 300);
        stationDistance.put("MAQ", 600);
        stationDistance.put("MAO", 1000);
        stationDistance.put("PNE", 1400);
        stationDistance.put("GHY", 4700);
        stationDistance.put("PTA", 3800);
        stationDistance.put("NJP", 4200);
    }

    public static int getDistance(String station) {
        return stationDistance.getOrDefault(station, -1);
    }
}
