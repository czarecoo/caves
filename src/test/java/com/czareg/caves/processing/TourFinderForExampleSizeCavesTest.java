package com.czareg.caves.processing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TourFinderForExampleSizeCavesTest {

    @Test
    void shouldFindBestPathInExample() {
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

        assertThat(result).isIn("1 3 2 7 8 6 4 5", "1 5 4 6 8 7 2 3");
    }

    @Test
    void shouldFindBestPathInModifiedExample() {
        String input = """
                8 5
                1 3 0
                3 2 1
                7 3 0
                7 2 0
                8 7 0
                1 8 0
                6 8 0
                6 4 0
                6 5 0
                5 4 0
                2 4 0
                5 1 1
                """;
        List<String> inputLines = input.lines().toList();

        String result = TourFinder.find(inputLines);

        assertThat(result).isIn("1 3 7 2 4 5 6 8", "1 8 6 5 4 2 7 3");
    }

    @Test
    void shouldFindBestPathInAnotherModifiedExample() {
        String input = """
                8 5
                1 3 0
                3 2 0
                7 3 0
                7 2 0
                8 7 1
                1 8 0
                6 8 0
                6 4 0
                6 5 0
                5 4 0
                2 4 0
                5 1 1
                """;
        List<String> inputLines = input.lines().toList();

        String result = TourFinder.find(inputLines);

        assertThat(result).isIn("1 3 7 2 4 5 6 8", "1 8 6 5 4 2 7 3");
    }

    @Test
    void shouldFindBestPathInExampleButWithManyMoreDifficultCorridors() {
        String input = """
                8 5
                1 3 1
                3 2 1
                7 3 0
                7 2 0
                8 7 0
                1 8 0
                6 8 1
                6 4 0
                6 5 0
                5 4 1
                2 4 1
                5 1 1
                """;
        List<String> inputLines = input.lines().toList();

        String result = TourFinder.find(inputLines);

        assertThat(result).isIn("1 5 6 4 2 3 7 8", "1 8 7 3 2 4 6 5");
    }
}