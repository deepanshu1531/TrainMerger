package com.example.geektrust;

import java.util.*;

public class TrainMerger {

    public static List<String> getArrivalBogieList(String[] trainParts) {
        List<String> result = new ArrayList<>();
        result.add("ENGINE");

        for (int i = 1; i < trainParts.length; i++) {
            String bogie = trainParts[i];

            if ("ENGINE".equals(bogie)) continue;

            if (!StationInfo.stationDistance.containsKey(bogie)) {
                System.out.println("Warning: Unknown station code '" + bogie + "' skipped.");
                continue;
            }

            int dist = StationInfo.getDistance(bogie);
            if (dist > StationInfo.getDistance("HYB")) {
                result.add(bogie);
            }
        }
        return result;
    }

    public static List<String> getDepartureBogieList(List<String> trainA, List<String> trainB) {
        List<String> combined = new ArrayList<>();
        combined.add("ENGINE");
        combined.add("ENGINE");

        List<String> bogies = new ArrayList<>();
        bogies.addAll(trainA.subList(1, trainA.size()));
        bogies.addAll(trainB.subList(1, trainB.size()));

        bogies.removeIf(b -> !StationInfo.stationDistance.containsKey(b)); 
        bogies.sort((a, b) -> Integer.compare(
                StationInfo.getDistance(b),
                StationInfo.getDistance(a)));

        if (bogies.isEmpty()) {
            return Collections.singletonList("JOURNEY_ENDED");
        }

        combined.addAll(bogies);
        return combined;
    }
}
