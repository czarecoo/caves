package com.czareg.caves.processing;

import lombok.experimental.UtilityClass;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultUndirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.Arrays;
import java.util.List;

@UtilityClass
public class GraphFactory {

    public static Graph<Integer, DefaultWeightedEdge> create(List<String> inputLines) {
        Graph<Integer, DefaultWeightedEdge> graph = new DefaultUndirectedWeightedGraph<>(DefaultWeightedEdge.class);

        int[] firstLineValues = readIntegersFromLine(inputLines.getFirst());
        int allRooms = firstLineValues[0];

        for (int i = 1; i <= allRooms; i++) {
            graph.addVertex(i);
        }

        for (int lineIndex = 1; lineIndex < inputLines.size(); lineIndex++) {
            int[] lineValues = readIntegersFromLine(inputLines.get(lineIndex));
            int firstRoom = lineValues[0];
            int secondRoom = lineValues[1];
            int difficulty = lineValues[2];
            double weight = difficulty == 0 ? 1.0 : 10.0;
            graph.setEdgeWeight(graph.addEdge(firstRoom, secondRoom), weight);
        }

        // Ensure the graph is complete by adding missing edges with a high weight
        double maxDifficulty = 100_000.0; // Arbitrary high value for missing edges
        for (int i = 1; i <= allRooms; i++) {
            for (int j = 1; j <= allRooms; j++) {
                if (i != j && !graph.containsEdge(i, j)) {
                    graph.setEdgeWeight(graph.addEdge(i, j), maxDifficulty);
                }
            }
        }

        return graph;
    }

    private static int[] readIntegersFromLine(String line) {
        return Arrays.stream(line.trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
