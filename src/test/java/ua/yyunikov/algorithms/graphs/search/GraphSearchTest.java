package ua.yyunikov.algorithms.graphs.search;

import org.junit.Assert;
import org.junit.Test;
import ua.yyunikov.algorithms.graphs.Graph;
import ua.yyunikov.algorithms.graphs.GraphAlgorithmTest;
import ua.yyunikov.algorithms.graphs.Vertex;
import ua.yyunikov.algorithms.util.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GraphSearchTest extends GraphAlgorithmTest {

    protected static final Graph TEST_SEARCH_GRAPH = new Graph();
    protected static final List<Vertex> TEST_SEARCH_VERTICES = new ArrayList<>(4);
    static {
        final Vertex vertexOne = new Vertex(1);
        final Vertex vertexTwo = new Vertex(2);
        final Vertex vertexThree = new Vertex(3);
        final Vertex vertexFour = new Vertex(4);
        final Vertex vertexFive = new Vertex(5);
        final Vertex vertexSix = new Vertex(6);

        TEST_SEARCH_GRAPH.addVertex(vertexOne);
        TEST_SEARCH_GRAPH.addVertex(vertexTwo);
        TEST_SEARCH_GRAPH.addVertex(vertexThree);
        TEST_SEARCH_GRAPH.addVertex(vertexFour);
        TEST_SEARCH_GRAPH.addVertex(vertexFive);
        TEST_SEARCH_GRAPH.addVertex(vertexSix);

        TEST_SEARCH_VERTICES.add(vertexOne);
        TEST_SEARCH_VERTICES.add(vertexTwo);
        TEST_SEARCH_VERTICES.add(vertexThree);
        TEST_SEARCH_VERTICES.add(vertexFour);
        TEST_SEARCH_VERTICES.add(vertexFive);
        TEST_SEARCH_VERTICES.add(vertexSix);

        TEST_SEARCH_GRAPH.createEdge(vertexOne, vertexTwo, 1);
        TEST_SEARCH_GRAPH.createEdge(vertexOne, vertexThree, 4);
        TEST_SEARCH_GRAPH.createEdge(vertexTwo, vertexFour, 2);
        TEST_SEARCH_GRAPH.createEdge(vertexThree, vertexFour, 6);
        TEST_SEARCH_GRAPH.createEdge(vertexThree, vertexFive, 3);
        TEST_SEARCH_GRAPH.createEdge(vertexFour, vertexFive, 3);
        TEST_SEARCH_GRAPH.createEdge(vertexFive, vertexSix, 3);
    }

    @Test
    public void testBreadthFirstSearch() {
        testSearch("Breadth-first search", new BreadthFirstSearch());
    }

    @Test
    public void testDepthFirstSearch() {
        testSearch("Depth-first search", new DepthFirstSearch());
    }

    private void testSearch(final String algorithmName, final GraphSearch graphSearch) {
        runningTimeOf(algorithmName, () -> {
            Assert.assertTrue(graphSearch.search(createTestGraph(), testVertices.get(3)).isPresent());
            Assert.assertTrue(graphSearch.search(createTestGraph(), new Vertex(4)).isPresent());
            Assert.assertTrue(graphSearch.search(createTestGraph(), 4).isPresent());
            Assert.assertFalse(graphSearch.search(createTestGraph(), new Vertex(99)).isPresent());
            Assert.assertFalse(graphSearch.search(createTestGraph(), 99).isPresent());
            Assert.assertTrue(graphSearch.search(TEST_SEARCH_GRAPH, new Vertex(4)).isPresent());
            Assert.assertTrue(graphSearch.search(TEST_SEARCH_GRAPH, TEST_SEARCH_VERTICES.get(5)).isPresent());
            Assert.assertFalse(graphSearch.search(TEST_SEARCH_GRAPH, new Vertex(9)).isPresent());
            Assert.assertTrue(graphSearch.search(TEST_SEARCH_GRAPH, new Vertex(6)).isPresent());

            try {
                final Graph graph = Graph.createGraph(FileUtils.twoDimensionalArray("src/test/java/ua/yyunikov/algorithms/graphs/testGraph.txt"));
                Assert.assertTrue(graphSearch.search(graph, 151).isPresent());
            } catch (final IOException e) {
                System.err.println("Unexpected error: " + e);
            }
        });
    }
}
