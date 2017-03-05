package com.yunikov.algorithms.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of edge for graph.
 */
public class Edge {

    private final List<Vertex> ends = new ArrayList<>();

    private int weight;

    /**
     * Constructor.
     *
     * @param v1 one end of edge
     * @param v2 second end of edge
     */
    public Edge(final Vertex v1, final Vertex v2) {
        this(v1, v2, 0);
    }

    /**
     * Constructor.
     *
     * @param v1 one end of edge
     * @param v2 second end of edge
     * @param weight weight of edge
     */
    public Edge(final Vertex v1, final Vertex v2, final int weight) {
        if (v1 == null || v2 == null) {
            throw new IllegalArgumentException("Both vertices are required");
        }

        ends.add(v1);
        ends.add(v2);
        this.weight = weight;
    }

    /**
     * Returns true if vertex v1 and vertex v2 are present.
     *
     * @param v1 one end of edge
     * @param v2 second end of edge
     * @return true if vertex v1 and vertex v2 are present, false otherwise
     */
    public boolean contains(final Vertex v1, final Vertex v2) {
        return ends.contains(v1) && ends.contains(v2);
    }

    /**
     * Gets the opposite vertex on edge for specified one.
     *
     * @param v vertex to search opposite for
     * @return opposite vertex
     * @throws IllegalArgumentException if passed vertex is not in edge
     */
    public Vertex getOppositeVertex(final Vertex v) {
        if (!ends.contains(v)) {
            throw new IllegalArgumentException("Vertex " + v.getLabel());
        }

        return ends.get(1 - ends.indexOf(v));
    }

    /**
     * Replaces one vertex with another.
     *
     * @param oldVertex vertex which are going to be replaced
     * @param newVertex vertex with which to replace
     * @throws IllegalArgumentException if passed vertex is not in edge
     */
    public void replaceVertex(final Vertex oldVertex, final Vertex newVertex) {
        if (!ends.contains(oldVertex)) {
            throw new IllegalArgumentException("Vertex " + oldVertex.getLabel());
        }

        ends.remove(oldVertex);
        ends.add(newVertex);
    }

    /**
     * Gets the list of ends for edge.
     *
     * @return list of ends
     */
    public List<Vertex> getEnds() {
        return ends;
    }

    /**
     * Weight (length) of the edge.
     *
     * @return weight of the edge
     */
    public int getWeight() {
        return weight;
    }
}
