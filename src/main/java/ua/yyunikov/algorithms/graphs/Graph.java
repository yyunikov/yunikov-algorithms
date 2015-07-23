package ua.yyunikov.algorithms.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Representation of a graph.
 */
public class Graph {

    private final Map<Integer, Vertex> vertices = new TreeMap<>(Integer::compareTo);

    private final List<Edge> edges = new ArrayList<>();

    /**
     * Creates the graph from two dimensional array.
     *
     * @param array array to create a graph from
     * @return created graph
     */
    public static Graph createGraph(int[][] array) {
        final Graph graph = new Graph();

        for (int i = 0; i < array.length; i++) {
            final Vertex currentVertex = graph.getVertexOrAdd(i);

            for (int edgeTo : array[i]) {
                final Vertex secondVertex = graph.getVertexOrAdd(edgeTo);
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

    /**
     * Adds a vertex to a graph.
     *
     * @param v vertex to add
     */
    public void addVertex(final Vertex v) {
        vertices.put(v.getLabel(), v);
    }

    /**
     * Gets the vertex by label or add the new vertex with such label if it is not found.
     *
     * @param label vertex label
     * @return vertex with specified label
     */
    public Vertex getVertexOrAdd(final int label) {
        final Vertex vertexByLabel = vertices.get(label);
        if (vertexByLabel != null) {
            return vertexByLabel;
        }

        final Vertex newVertex = new Vertex(label);
        addVertex(newVertex);

        return newVertex;
    }

    /**
     * Gets the list of graph edges.
     *
     * @return list of graph edges
     */
    public List<Edge> getEdges() {
        return edges;
    }

    /**
     * Gets the map of graph vertices containing labels as keys and vertices as values.
     *
     * @return map of graph vertices
     */
    public Map<Integer, Vertex> getVertices() {
        return vertices;
    }
}
