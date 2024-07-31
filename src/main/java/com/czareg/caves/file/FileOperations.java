package com.czareg.caves.file;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@UtilityClass
public class FileOperations {

    private static final String INPUT_FILE_NAME = "CAV.IN";
    private static final String OUTPUT_FILE_NAME = "CAV.OUT";

    public static List<String> readLinesFromFile() {
        try {
            Path path = FilePathProvider.provide().resolve(INPUT_FILE_NAME);
            return Files.readAllLines(path);
        } catch (IOException | URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void saveOutputToFile(@NonNull String output) {
        try {
            Path path = FilePathProvider.provide().resolve(OUTPUT_FILE_NAME);
            Files.writeString(path, output);
        } catch (IOException | URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }
}
