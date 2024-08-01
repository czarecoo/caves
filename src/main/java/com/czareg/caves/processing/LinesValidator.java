package com.czareg.caves.processing;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;

@UtilityClass
public class LinesValidator {

    public static void validate(List<String> inputLines) {
        validateLinesNotEmpty(inputLines);
        int[] firstLineValues = readIntegersFromLine(inputLines.getFirst());
        int allRooms = firstLineValues[0];
        validateAllRooms(allRooms);
        int exteriorRooms = firstLineValues[1]; //unused but required
        validateExteriorRooms(exteriorRooms, allRooms);

        for (int lineIndex = 1; lineIndex < inputLines.size(); lineIndex++) {
            int[] lineValues = readIntegersFromLine(inputLines.get(lineIndex));
            int firstRoom = lineValues[0];
            validateRoom(firstRoom, allRooms);
            int secondRoom = lineValues[1];
            validateRoom(secondRoom, allRooms);
            validateRoomsAreDifferent(firstRoom, secondRoom);
            int difficulty = lineValues[2];
            validateDifficulty(difficulty);
        }
    }

    private static int[] readIntegersFromLine(String line) {
        if (line.isBlank()) {
            throw new IllegalArgumentException("Line is blank");
        }
        int[] values = Arrays.stream(line.trim().split(" "))
                .mapToInt(LinesValidator::parseIntOrThrow)
                .toArray();
        if (values.length != 2 && values.length != 3) {
            throw new IllegalArgumentException("Number of integers in line must satisfy: (integers == 2 or integers == 3)");
        }
        return values;
    }

    private static void validateLinesNotEmpty(List<String> lines) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException("Input file is empty");
        }
    }

    private static void validateAllRooms(int allRooms) {
        if (allRooms <= 3 || allRooms > 500) {
            throw new IllegalArgumentException("Number of all rooms must satisfy: (3 < allRooms <= 500)");
        }
    }

    private static void validateExteriorRooms(int exteriorRooms, int allRooms) {
        if (exteriorRooms < 3 || exteriorRooms >= allRooms) {
            throw new IllegalArgumentException("Number of exterior rooms must satisfy: (3 <= exteriorRooms < allRooms)");
        }
    }

    private static void validateRoom(int room, int allRooms) {
        if (room <= 0 || room > allRooms) {
            throw new IllegalArgumentException("Room must satisfy: (0 < room <= allRooms)");
        }
    }

    private static void validateRoomsAreDifferent(int firstRoom, int secondRoom) {
        if (firstRoom == secondRoom) {
            throw new IllegalArgumentException("Room cannot have a corridor to itself");
        }
    }

    private static void validateDifficulty(int difficulty) {
        if (difficulty != 0 && difficulty != 1) {
            throw new IllegalArgumentException("Difficulty must satisfy: (difficulty == 0 or difficulty == 1)");
        }
    }

    private static int parseIntOrThrow(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Failed to parse string to int", e);
        }
    }
}
