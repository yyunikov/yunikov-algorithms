package ua.yyunikov.algorithms.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of edge for graph.
 */
public class Edge<T> {

    private final List<T> ends = new ArrayList<>();

    private int weight;

    /**
     * Constructor.
     *
     * @param startVertex one end of edge
     * @param endVertex second end of edge
     */
    public Edge(final T startVertex, final T endVertex) {
        if (startVertex == null || endVertex == null) {
            throw new IllegalArgumentException("Both vertices are required");
        }

        ends.add(startVertex);
        ends.add(endVertex);
    }

    /**
     * Constructor.
     *
     * @param startVertex one end of edge
     * @param endVertex second end of edge
     * @param weight weight of edge
     */
    public Edge(final T startVertex, final T endVertex, final int weight) {
        this(startVertex, endVertex);
        this.weight = weight;
    }

    /**
     * Returns true if vertex v1 and vertex v2 are present.
     *
     * @param startVertex one end of edge
     * @param endVertex second end of edge
     * @return true if vertex v1 and vertex v2 are present, false otherwise
     */
    public boolean contains(final T startVertex, final T endVertex) {
        return ends.contains(startVertex) && ends.contains(endVertex);
    }

    /**
     * Gets the opposite vertex on edge for specified one.
     *
     * @param vertex vertex to search opposite for
     * @return opposite vertex
     * @throws IllegalArgumentException if passed vertex is not in edge
     */
    public T getOppositeVertex(final T vertex) {
        if (!ends.contains(vertex)) {
            throw new IllegalArgumentException("Vertex is not present in current edge");
        }

        return ends.get(1 - ends.indexOf(vertex));
    }

    /**
     * Replaces one vertex with another.
     *
     * @param oldVertex vertex which are going to be replaced
     * @param newVertex vertex with which to replace
     * @throws IllegalArgumentException if passed vertex is not in edge
     */
    public void replaceVertex(final T oldVertex, final T newVertex) {
        if (!ends.contains(oldVertex)) {
            throw new IllegalArgumentException("Vertex is not present in current edge");
        }

        ends.remove(oldVertex);
        ends.add(newVertex);
    }

    /**
     * Checks if the edge has vertex1 and vertex2 ends.
     *
     * @param vertex1 one end
     * @param vertex2 second end
     * @return true if edge contains vertex1 and vertex2, false otherwise
     */
    public boolean hasEnds(final T vertex1, final T vertex2) {
        return ends.contains(vertex1) && ends.contains(vertex2);
    }

    /**
     * Gets the list of ends for edge.
     *
     * @return list of ends
     */
    public List<T> getEnds() {
        return ends;
    }

    /**
     * Gets the weight of the edge. Default to 0.
     *
     * @return weight of the edge
     */
    public int getWeight() {
        return weight;
    }
}
