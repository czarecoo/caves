package com.czareg.caves.processing;

import lombok.experimental.UtilityClass;
import org.jgrapht.Graph;
import org.jgrapht.GraphTests;
import org.jgrapht.alg.cycle.HierholzerEulerianCycle;
import org.jgrapht.alg.interfaces.HamiltonianCycleAlgorithm;
import org.jgrapht.alg.tour.*;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class GraphProcessor {

    public static String process(Graph<Integer, DefaultWeightedEdge> graph) {
        HamiltonianCycleAlgorithm<Integer, DefaultWeightedEdge> solver = createAlgorithm();

        List<Integer> cycle = solver.getTour(graph).getVertexList().stream().collect(Collectors.toList());
        cycle.removeLast();

        while (cycle.getFirst() != 1){
            cycle.add(cycle.removeFirst());
        }

        return cycle.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    private static HamiltonianCycleAlgorithm<Integer, DefaultWeightedEdge> createAlgorithm() {
        return new ChristofidesThreeHalvesApproxMetricTSP<>();
    }

   /* public static String process(Graph<Integer, DefaultWeightedEdge> graph) {
        List<Integer> cycle = findHamiltonianPath(graph, 1);
        //cycle.removeLast();

        *//*while (cycle.getFirst() != 1) {
            cycle.add(cycle.removeFirst());
        }*//*

        return cycle.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    public List<Integer> findHamiltonianPath(Graph<Integer, DefaultWeightedEdge> graph, int startVertex) {
        List<Integer> path = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        path.add(startVertex);
        visited.add(startVertex);

        if (findPath(graph, startVertex, visited, path, false)) {
            return path;
        }

        return Collections.emptyList(); // Return an empty list if no path is found
    }

    private boolean findPath(Graph<Integer, DefaultWeightedEdge> graph, int currentVertex, Set<Integer> visited, List<Integer> path, boolean usedWeightOneEdge) {
        if (visited.size() == graph.vertexSet().size()) {
            return true; // All vertices have been visited
        }

        List<DefaultWeightedEdge> edges = new ArrayList<>(graph.edgesOf(currentVertex));
        edges.sort(Comparator.comparingDouble(graph::getEdgeWeight));

        for (DefaultWeightedEdge edge : edges) {
            Integer nextVertex = Graphs.getOppositeVertex(graph, edge, currentVertex);
            double edgeWeight = graph.getEdgeWeight(edge);

            if (!visited.contains(nextVertex)) {
                if (edgeWeight == 1 && usedWeightOneEdge) {
                    continue; // Skip if we already used a weight 1 edge
                }

                visited.add(nextVertex);
                path.add(nextVertex);

                if (findPath(graph, nextVertex, visited, path, usedWeightOneEdge || edgeWeight == 1)) {
                    return true;
                }

                visited.remove(nextVertex);
                path.removeLast();
            }
        }

        return false;
    }*/

}
