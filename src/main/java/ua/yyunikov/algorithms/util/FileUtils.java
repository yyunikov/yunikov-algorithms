package ua.yyunikov.algorithms.util;

import ua.yyunikov.algorithms.graphs.Graph;
import ua.yyunikov.algorithms.graphs.Vertex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Utilities for performing different kind of operations with files.
 */
public interface FileUtils {

    /**
     * Reads the values from file into integer array.
     *
     * @param relPath path to file
     * @return integer array that was read
     * @throws IOException if any error occurs
     */
    static int[] toIntArray(final String relPath) throws IOException {
        return Files.lines(Paths.get(relPath)).mapToInt(Integer::valueOf).toArray();
    }

    /**
     * Reads the values from file into long array.
     *
     * @param relPath path to file
     * @return long array that was read
     * @throws IOException if any error occurs
     */
    static long[] toLongArray(final String relPath) throws IOException {
        return Files.lines(Paths.get(relPath)).mapToLong(Long::valueOf).toArray();
    }

    /**
     * Reads the values from file into two dimensional array.
     * File should be formed accordingly with integers only and numbers should be divided by tabs in row.
     *
     * @param relPath path to file
     * @return result in view of two dimensional array
     * @throws IOException if any error occurs
     */
    static int[][] twoDimensionalArray(final String relPath) throws IOException {
        final Map<Integer, List<Integer>> lines = new LinkedHashMap<>();

        Files.lines(Paths.get(relPath)).forEach(line -> {
            final String[] split = line.trim().split("(\\s)+");
            final List<Integer> adjList = new ArrayList<>();
            for(int i = 1; i < split.length; i++) {
                adjList.add(Integer.parseInt(split[i]) - 1);
            }

            lines.put(Integer.parseInt(split[0]) - 1, adjList);
        });

        final int[][] array = new int[lines.size()][];
        for (final Map.Entry<Integer, List<Integer>> entry : lines.entrySet() ) {
            final List<Integer> adjList = entry.getValue();
            final int[] adj = new int[adjList.size()];

            for(int i = 0; i < adj.length; i++) {
                adj[i] = adjList.get(i);
            }

            array[entry.getKey()] = adj;
        }

        return array;
    }

    /**
     * Reads the file and creates a graph from it. First column of file should be labels of vertices,
     * all other entries are separated by comma and means edge with weight, so for example, 40,2242 entry in 2nd row means
     * that weight of edge from 2 to 40 is 2242.
     *
     * @param relPath path to file
     * @return graph representation
     * @throws IOException if any error occurs
     */
    static Graph graphFromFile(final String relPath) throws IOException {
        final Graph graph = new Graph();

        Files.lines(Paths.get(relPath)).forEach(line -> {
            final String[] split = line.trim().split("(\\s)+");

            for(int i = 0; i < split.length; i++) {
                final Vertex currentVertex = graph.getVertexOrAdd(Integer.valueOf(split[0]));

                if (i != 0) {
                    final String[] splitItem = split[i].split(",");
                    final Vertex secondVertex = graph.getVertexOrAdd(Integer.valueOf(splitItem[0]));
                    graph.createEdge(currentVertex, secondVertex, Integer.valueOf(splitItem[1]));
                }
            }
        });

        return graph;
    }
}
