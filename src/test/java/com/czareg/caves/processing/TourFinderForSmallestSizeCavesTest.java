package com.czareg.caves.processing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TourFinderForSmallestSizeCavesTest {

    @Test
    void shouldFindPathWhenOneCorridorBetween4And1IsBlocked() {
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

        assertThat(result).isIn("1 2 4 3", "1 3 4 2");
    }

    @Test
    void shouldFindPathWhenOneCorridorBetween4And2IsBlocked() {
        String input = """
                4 3
                1 2 0
                2 3 0
                3 1 0
                4 1 0
                4 2 1
                4 3 0
                """;
        List<String> inputLines = input.lines().toList();

        String result = TourFinder.find(inputLines);

        assertThat(result).isIn("1 2 3 4", "1 4 3 2");
    }

    @Test
    void shouldFindPathWhenOneCorridorBetween4And3IsBlocked() {
        String input = """
                4 3
                1 2 0
                2 3 0
                3 1 0
                4 1 0
                4 2 0
                4 3 1
                """;
        List<String> inputLines = input.lines().toList();

        String result = TourFinder.find(inputLines);

        assertThat(result).isIn("1 3 2 4", "1 4 2 3");
    }

    @Test
    void shouldFindPathWhenThreeCorridorsAreBlocked() {
        String input = """
                4 3
                1 2 1
                2 3 0
                3 1 1
                4 1 0
                4 2 0
                4 3 1
                """;
        List<String> inputLines = input.lines().toList();

        String result = TourFinder.find(inputLines);

        assertThat(result).isIn("1 4 2 3", "1 3 2 4");
    }

    @Test
    void shouldFindPathWhenThreeDifferentCorridorsAreBlocked() {
        String input = """
                4 3
                1 2 1
                2 3 0
                3 1 1
                4 1 0
                4 2 1
                4 3 0
                """;
        List<String> inputLines = input.lines().toList();

        String result = TourFinder.find(inputLines);

        assertThat(result).isIn("1 4 3 2", "1 2 3 4");
    }

    @Test
    void shouldFindPathWhenThreeMoreDifferentCorridorsAreBlocked() {
        String input = """
                4 3
                1 2 0
                2 3 1
                3 1 1
                4 1 1
                4 2 0
                4 3 0
                """;
        List<String> inputLines = input.lines().toList();

        String result = TourFinder.find(inputLines);

        assertThat(result).isIn("1 3 4 2", "1 2 4 3");
    }
}