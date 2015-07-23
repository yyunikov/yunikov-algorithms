package ua.yyunikov.algorithms.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Graph {

    private final Map<Integer, Vertex> vertices = new TreeMap<>(Integer::compareTo);
    private final List<Edge> edges = new ArrayList<>();

    public static Graph createGraph(int[][] array) {
        final Graph graph = new Graph();

        for (int i = 0; i < array.length; i++) {
            final Vertex currentVertex = graph.getVertex(i);

            for (int edgeTo : array[i]) {
                final Vertex secondVertex = graph.getVertex(edgeTo);
                final Edge edge = secondVertex.getEdgeTo(currentVertex);

                if(edge == null) {
                    createEdge(graph, currentVertex, secondVertex);
                }
            }
        }

        return graph;
    }

    private static Edge createEdge(final Graph graph, final Vertex firstVertex, final Vertex secondVertex) {
        final Edge edge = new Edge(firstVertex, secondVertex);

        graph.getEdges().add(edge);
        firstVertex.addEdge(edge);
        secondVertex.addEdge(edge);

        return edge;
    }

    public void addVertex(final Vertex v) {
        vertices.put(v.getLabel(), v);
    }

    public Vertex getVertex( int label ) {
        final Vertex vertexByLabel = vertices.get(label);
        if (vertexByLabel != null) {
            return vertexByLabel;
        }

        final Vertex newVertex = new Vertex(label);
        addVertex(newVertex);

        return newVertex;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public Map<Integer, Vertex> getVertices() {
        return vertices;
    }
}
