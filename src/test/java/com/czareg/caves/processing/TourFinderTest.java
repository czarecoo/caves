package com.czareg.caves.processing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TourFinderTest {

    @Test
    void a() {
        String input = """
                8 5
                1 3 0
                3 2 0
                7 3 1
                7 2 0
                8 7 0
                1 8 0
                6 8 0
                6 4 0
                6 5 1
                5 4 0
                2 4 0
                5 1 0
                """;
        List<String> inputLines = input.lines().toList();

        String result = TourFinder.find(inputLines);

        String expected = "1 5 4 6 8 7 2 3";
        assertEquals(expected, result);
    }

    @Test
    void b() {
        String input = """
                4 3
                1 2 0
                2 3 0
                3 1 0
                4 1 0
                4 2 0
                4 3 0
                """;
        List<String> inputLines = input.lines().toList();

        String result = TourFinder.find(inputLines);

        String expected = "1 4 3 2";
        assertEquals(expected, result);
    }

    @Test
    void c() {
        String input = """
                4 3
                1 2 0
                2 3 0
                3 1 0
                4 1 1
                4 2 0
                4 3 0
                """;
        List<String> inputLines = input.lines().toList();

        String result = TourFinder.find(inputLines);

        String expected = "1 2 4 3";
        assertEquals(expected, result);
    }
}