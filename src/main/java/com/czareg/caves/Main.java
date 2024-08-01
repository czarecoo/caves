package com.czareg.caves;

import com.czareg.caves.file.FileOperations;
import com.czareg.caves.processing.TourFinder;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> inputLines = FileOperations.readLinesFromFile();
        String output = TourFinder.find(inputLines);
        FileOperations.saveOutputToFile(output);
    }
}