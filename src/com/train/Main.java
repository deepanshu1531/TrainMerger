package com.train;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String filePath = "src/input.txt"; 

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            if (lines == null || lines.isEmpty()) {
                System.out.println("Input file is empty or unreadable.");
                return;
            }

            for (int i = 0; i < lines.size(); i++) {
                String lineA = lines.get(i).trim();

                // Skip blank or malformed lines
                if (lineA.isEmpty() || !lineA.startsWith("TRAIN_A")) continue;

                if (i + 1 >= lines.size()) {
                    System.out.println("Missing TRAIN_B input after TRAIN_A at line " + (i + 1));
                    break;
                }

                String lineB = lines.get(i + 1).trim();
                if (!lineB.startsWith("TRAIN_B")) {
                    System.out.println("Expected TRAIN_B after TRAIN_A at line " + (i + 1));
                    i++; // Skip next line to keep going
                    continue;
                }

                try {
                    String[] trainA = lineA.split("\\s+");
                    String[] trainB = lineB.split("\\s+");

                    List<String> arrivalA = TrainMerger.getArrivalBogieList(trainA);
                    List<String> arrivalB = TrainMerger.getArrivalBogieList(trainB);

                    System.out.println("ARRIVAL TRAIN_A " + String.join(" ", arrivalA));
                    System.out.println("ARRIVAL TRAIN_B " + String.join(" ", arrivalB));

                    List<String> departure = TrainMerger.getDepartureBogieList(arrivalA, arrivalB);
                    if (departure.size() == 1 && "JOURNEY_ENDED".equals(departure.get(0))) {
                        System.out.println("DEPARTURE TRAIN_AB JOURNEY_ENDED");
                    } else {
                        System.out.println("DEPARTURE TRAIN_AB " + String.join(" ", departure));
                    }
                } catch (Exception e) {
                    System.out.println("Error processing input at lines " + (i + 1) + " and " + (i + 2) + ": " + e.getMessage());
                }

                System.out.println(); 
                i++;
            }

        } catch (IOException e) {
            System.out.println("Error reading the input file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
