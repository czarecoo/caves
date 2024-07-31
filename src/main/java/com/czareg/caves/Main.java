package com.czareg.caves;

import com.czareg.caves.file.FileOperations;
import com.czareg.caves.processing.TourFinder;
import org.jgrapht.Graph;
import org.jgrapht.GraphTests;
import org.jgrapht.alg.tour.GreedyHeuristicTSP;
import org.jgrapht.graph.DefaultUndirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.List;

/*
In Bajtocja, each cave has the following characteristics:

-All chambers and corridors are on the same level,
-Corridors do not intersect,
-Some chambers are on the perimeter of the cave — these are called external chambers,
-All other chambers, located inside, are called internal chambers,
-The entrance to the cave leads to one of the external chambers,
-Each chamber has exactly three corridors leading to three different other chambers; if a chamber is external,
two of the corridors lead to neighboring external chambers on the perimeter of the cave, and one leads to an internal chamber,
-Corridors connecting external chambers are called external corridors, and all others are called internal corridors,
-From each chamber, it is possible to reach any other chamber using only internal corridors, but if it is also required
to pass through each corridor at most once, this can be done in only one way,
-Not all corridors are equally easy to traverse — they are divided into two categories: easy and difficult.

It has been decided to open all caves for visitors. To ensure smooth and safe visitor flow, a touring route must be established in each cave that passes through each chamber exactly once.
The only exception to this rule is the entrance chamber, where the tour starts and ends (i.e., visitors pass through this chamber exactly twice).
The touring route should be designed for the average tourist and contain as few difficult corridors as possible.


Task
Write a program that:

Reads the description of the cave from the text file CAV.IN.
Finds a touring route that starts and ends in the entrance chamber, passes through each chamber exactly once, and traverses the minimum number of difficult corridors.
Writes the result to the text file CAV.OUT.

Input
In the first line of the text file CAV.IN, there are two integers n and k (separated by a single space).
The number n, 3 < n ≤ 500, is the total number of chambers in the cave, and k, k ≥ 3, is the number of external chambers.
The chambers are numbered from 1 to n. The entrance chamber is numbered 1. The external chambers are numbered 1, 2, ..., k,
although they do not necessarily lie on the perimeter of the cave in that order. The next 3n/2 lines of the file contain descriptions of the corridors.
The description of each corridor consists of three integers a, b, and c (separated by single spaces).
The numbers a and b are the numbers of the chambers connected by the corridor. The number c is either 0 or 1 — 0 means the corridor is easy, and 1 means it is difficult.

Output
Your program should write in the first line of the text file CAV.OUT a sequence of n integers separated by single spaces.
The first number should be 1 (the number of the entrance chamber), and the next n - 1 numbers should be the numbers of the subsequent chambers in the tour route.
 */
public class Main {

    public static void main(String[] args) {
        List<String> inputLines = FileOperations.readLinesFromFile();
        String output = TourFinder.find(inputLines);
        FileOperations.saveOutputToFile(output);
    }
}