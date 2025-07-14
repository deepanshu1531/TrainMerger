package com.example.geektrust;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		String folderPath = "sample_input";

		try (Stream<Path> paths = Files.walk(Paths.get(folderPath))) {
			List<Path> txtFiles = paths.filter(Files::isRegularFile).filter(p -> p.toString().endsWith(".txt"))
					.toList();

			if (txtFiles.isEmpty()) {
				System.out.println("No input files found in the folder: " + folderPath);
				return;
			}

			for (Path file : txtFiles) {
				System.out.println("Processing File: " + file.getFileName());
				processFile(file);
				System.out.println(); // separator between files
			}

		} catch (IOException e) {
			System.out.println("Error accessing the input folder: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error occurred: " + e.getMessage());
		}
	}

	private static void processFile(Path filePath) {
		try {
			List<String> lines = Files.readAllLines(filePath);

			boolean isAllLinesEmpty = lines.stream().allMatch(line -> line.trim().isEmpty());
			if (lines == null || lines.isEmpty() || isAllLinesEmpty) {
				System.out.println("Input file " + filePath.getFileName() + " is empty or contains only whitespace.");
				return;
			}

			for (int i = 0; i < lines.size(); i++) {
				String lineA = lines.get(i).trim();

				if (lineA.isEmpty() || !lineA.startsWith("TRAIN_A"))
					continue;

				if (i + 1 >= lines.size()) {
					System.out.println("Missing TRAIN_B input after TRAIN_A at line " + (i + 1));
					break;
				}

				String lineB = lines.get(i + 1).trim();
				if (!lineB.startsWith("TRAIN_B")) {
					System.out.println("Expected TRAIN_B after TRAIN_A at line " + (i + 2));
					i++;
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
					System.out.println(
							"Error processing input at lines " + (i + 1) + " and " + (i + 2) + ": " + e.getMessage());
				}

				i++;
				System.out.println();
			}

		} catch (IOException e) {
			System.out.println("Error reading file " + filePath.getFileName() + ": " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error in file " + filePath.getFileName() + ": " + e.getMessage());
		}
	}
}
