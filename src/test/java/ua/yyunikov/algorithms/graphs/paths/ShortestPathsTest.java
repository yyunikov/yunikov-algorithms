package ua.yyunikov.algorithms.graphs.paths;

import org.junit.Assert;
import org.junit.Test;
import ua.yyunikov.algorithms.graphs.Graph;
import ua.yyunikov.algorithms.graphs.GraphAlgorithmTest;
import ua.yyunikov.algorithms.graphs.Vertex;
import ua.yyunikov.algorithms.util.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShortestPathsTest extends GraphAlgorithmTest {

    @Test
    public void testDijktrasShortestPath() {
        testShortestPaths("Dijktras shortest parth", new DijkstrasShortestPath());
    }

    private void testShortestPaths(final String algorithmName, final ShortestPath shortestPath) {
        runningTimeOf(algorithmName, () -> {
            // test 1
            final Graph graph = createTestGraph();
            Assert.assertEquals(6, shortestPath.findShortestPath(graph, testVertices.get(0), testVertices.get(3)));

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
