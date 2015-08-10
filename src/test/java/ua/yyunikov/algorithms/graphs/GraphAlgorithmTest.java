package ua.yyunikov.algorithms.graphs;

import ua.yyunikov.algorithms.AlgorithmTest;

import java.util.ArrayList;
import java.util.List;

public class GraphAlgorithmTest extends AlgorithmTest {

    protected static Graph testGraph = createTestGraph();
    protected static List<Vertex> testVertices;

    protected static Graph createTestGraph() {
        final Graph graph = new Graph();
        final Vertex vertexOne = new Vertex(1);
        final Vertex vertexTwo = new Vertex(2);
        final Vertex vertexThree = new Vertex(3);
        final Vertex vertexFour = new Vertex(4);

        graph.addVertex(vertexOne);
        graph.addVertex(vertexTwo);
        graph.addVertex(vertexThree);
        graph.addVertex(vertexFour);

        testVertices = new ArrayList<>(4);
        testVertices.add(vertexOne);
        testVertices.add(vertexTwo);
        testVertices.add(vertexThree);
        testVertices.add(vertexFour);

        graph.createEdge(vertexOne, vertexTwo, 1);
        graph.createEdge(vertexOne, vertexThree, 4);
        graph.createEdge(vertexTwo, vertexThree, 2);
        graph.createEdge(vertexTwo, vertexFour, 6);
        graph.createEdge(vertexThree, vertexFour, 3);

        testGraph = graph;
        return graph;
    }
}
