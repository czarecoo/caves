package com.czareg.caves.processing;

import lombok.experimental.UtilityClass;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.List;

@UtilityClass
public class TourFinder {

    public static String find(List<String> inputLines) {
        LinesValidator.validate(inputLines);
        Graph<Integer, DefaultWeightedEdge> graph = GraphFactory.create(inputLines);
        return GraphProcessor.process(graph);
    }
}
