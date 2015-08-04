package ua.yyunikov.algorithms.graphs.paths;

import org.junit.Assert;
import org.junit.Test;
import ua.yyunikov.algorithms.AlgorithmTest;
import ua.yyunikov.algorithms.graphs.Graph;
import ua.yyunikov.algorithms.graphs.Vertex;
import ua.yyunikov.algorithms.util.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShortestPathsTest extends AlgorithmTest {

    @Test
    public void testDijktrasShortestPath() {
        testShortestPaths("Dijktras shortest parth", new DijkstrasShortestPath());
    }

    private void testShortestPaths(final String algorithmName, final ShortestPath shortestPath) {
        runningTimeOf(algorithmName, () -> {
            // test 1
            final Graph graph = new Graph();
            final Vertex vertexOne = new Vertex(1);
            final Vertex vertexTwo = new Vertex(2);
            final Vertex vertexThree = new Vertex(3);
            final Vertex vertexFour = new Vertex(4);

            graph.addVertex(vertexOne);
            graph.addVertex(vertexTwo);
            graph.addVertex(vertexThree);
            graph.addVertex(vertexFour);

            graph.createEdge(vertexOne, vertexTwo, 1);
            graph.createEdge(vertexOne, vertexThree, 4);
            graph.createEdge(vertexTwo, vertexThree, 2);
            graph.createEdge(vertexTwo, vertexFour, 6);
            graph.createEdge(vertexThree, vertexFour, 3);

            Assert.assertEquals(6, shortestPath.findShortestPath(graph, vertexOne, vertexFour));

            // test 2
            try {
                final Graph bigGraph = FileUtils.graphFromFile("src/test/java/ua/yyunikov/algorithms/graphs/paths/dijkstraData.txt");
                final List<Integer> toVertices = new ArrayList<>(Arrays.asList(7, 37, 59, 82, 99, 115, 133, 165, 188, 197));
                final List<Integer> shortestPaths = toVertices
                        .stream()
                        .map(vertex -> shortestPath.findShortestPath(bigGraph, bigGraph.getVertices().get(1), new Vertex(vertex)))
                        .collect(Collectors.toList());
                final List<Integer> expectedPaths = new ArrayList<>(Arrays.asList(2599, 2610, 2947, 2052, 2367, 2399, 2029, 2442, 2505, 3068));
                Assert.assertEquals(expectedPaths, shortestPaths);
            } catch (final IOException e) {
                System.err.println("Unexpected error: " + e);
            }
        });
    }
}
