package com.czareg.caves.processing;

import lombok.experimental.UtilityClass;
import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.HamiltonianCycleAlgorithm;
import org.jgrapht.alg.tour.NearestNeighborHeuristicTSP;
import org.jgrapht.alg.tour.TwoOptHeuristicTSP;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class GraphProcessor {

    private static final int NEAREST_NEIGHBOR_PASSES = 100;
    private static final Integer STARTING_VERTEX = 1;
    private static final double MIN_COST_IMPROVEMENT = 1.0;

    public static String process(Graph<Integer, DefaultWeightedEdge> graph) {
        HamiltonianCycleAlgorithm<Integer, DefaultWeightedEdge> solver = new TwoOptHeuristicTSP<>(
                NEAREST_NEIGHBOR_PASSES,
                new NearestNeighborHeuristicTSP<>(STARTING_VERTEX),
                MIN_COST_IMPROVEMENT);

        List<Integer> cycle = solver.getTour(graph).getVertexList();
        // cycle to path
        cycle.removeLast();

        // if needed, rewind path so that vertex 1 is first
        while (cycle.getFirst() != 1) {
            cycle.add(cycle.removeFirst());
        }

        return toString(cycle);
    }

    private static String toString(List<Integer> cycle) {
        return cycle.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
