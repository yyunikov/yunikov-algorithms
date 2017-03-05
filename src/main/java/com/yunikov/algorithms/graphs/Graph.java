package com.yunikov.algorithms.graphs;

import java.util.*;

/**
 * Representation of a graph.
 */
public class Graph {

    private final Map<Integer, Vertex> vertices = new HashMap<>();

    private final List<Edge> edges = new ArrayList<>();

    /**
     * Creates the graph from two dimensional array.
     *
     * @param array array to create a graph from
     * @return created graph
     */
    public static Graph createGraph(final int[][] array) {
        final Graph graph = new Graph();

        for (int i = 0; i < array.length; i++) {
            final Vertex currentVertex = graph.getVertexOrAdd(i);

            for (int edgeTo : array[i]) {
                final Vertex secondVertex = graph.getVertexOrAdd(edgeTo);
                final Optional<Edge> edge = secondVertex.getEdgeTo(currentVertex);

                if(!edge.isPresent()) {
                    graph.createEdge(currentVertex, secondVertex);
                }
            }
        }

        return graph;
    }

    /**
     * Creates edge in the graph from firstVertex to secondVertex.
     *
     * @param firstVertex one end of edge
     * @param secondVertex second end of edge
     * @param weight weight of edge
     * @return created edge
     */
    public Edge createEdge(final Vertex firstVertex, final Vertex secondVertex, final int weight) {
        final Edge edge = new Edge(firstVertex, secondVertex, weight);

        getEdges().add(edge);
        firstVertex.addEdge(edge);
        secondVertex.addEdge(edge);

        return edge;
    }

    /**
     * Creates edge in the graph from firstVertex to secondVertex.
     *
     * @param firstVertex one end of edge
     * @param secondVertex second end of edge
     * @return created edge
     */
    public Edge createEdge(final Vertex firstVertex, final Vertex secondVertex) {
        return createEdge(firstVertex, secondVertex, 0);
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
     * Gets the vertex by label or returns empty optional if it is not found.
     *
     * @param label vertex label
     * @return vertex with specified label or empty if not found
     */
    public Optional<Vertex> getVertex(final int label) {
        final Vertex vertexByLabel = vertices.get(label);
        if (vertexByLabel != null) {
            return Optional.of(vertexByLabel);
        }

        return Optional.empty();
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
