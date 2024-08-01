package com.czareg.caves.processing;

import lombok.experimental.UtilityClass;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.HamiltonianCycleAlgorithm;
import org.jgrapht.alg.tour.NearestNeighborHeuristicTSP;
import org.jgrapht.alg.tour.TwoOptHeuristicTSP;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class GraphProcessor {

    public static String process(Graph<Integer, DefaultWeightedEdge> graph) {
        HamiltonianCycleAlgorithm<Integer, DefaultWeightedEdge> solver = new TwoOptHeuristicTSP<>(
                100,
                new NearestNeighborHeuristicTSP<>(Integer.valueOf(1)),
                1.0);

        GraphPath<Integer, DefaultWeightedEdge> tour = solver.getTour(graph);

        List<Integer> cycle = tour.getVertexList();
        // cycle to path
        cycle.removeLast();

        // if needed, rewind path so that vertex 1 is first
        while (cycle.getFirst() != 1) {
            cycle.add(cycle.removeFirst());
        }

        return cycle.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
