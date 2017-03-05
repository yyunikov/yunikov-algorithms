package com.yunikov.algorithms.graphs;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Representation of vertex for graph.
 */
public class Vertex implements Comparable<Vertex> {

    private final int label;

    private final Object value;

    private final Set<Edge> edges = new HashSet<>();

    public Vertex(final int label) {
        this(label, null);
    }

    /**
     * Constructor.
     *
     * @param label label for vertex
     * @param value value of vertex
     */
    public Vertex(final int label, final Object value) {
        this.label = label;
        this.value = value;
    }

    /**
     * Adds the edge for current vertex.
     *
     * @param edge edge to add
     */
    public void addEdge(final Edge edge) {
        edges.add(edge);
    }

    /**
     * Gets the edge to another vertex, if vertex is not found - null is returned.
     *
     * @param v2 vertex for which to search edge for
     * @return edge for vertex v2 if found, null otherwise
     */
    public Optional<Edge> getEdgeTo(final Vertex v2) {
        for (final Edge edge : edges) {
            if(edge.contains(this, v2)) {
                return Optional.of(edge);
            }
        }

        return Optional.empty();
    }

    /**
     * Gets the vertex label.
     *
     * @return vertex label
     */
    public int getLabel() {
        return label;
    }

    /**
     * Gets the edges of vertex.
     *
     * @return vertex edgex
     */
    public Set<Edge> getEdges() {
        return edges;
    }

    /**
     * Gets the value of a vertex.
     *
     * @return vertex value
     */
    public Object getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Vertex vertex = (Vertex) o;

        return label == vertex.label && !(value != null ? !value.equals(vertex.value) :
                vertex.value != null) && !(edges != null ? !edges.equals(vertex.edges) : vertex.edges != null);

    }

    @Override
    public int hashCode() {
        int result = label;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (edges != null ? edges.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label=" + label +
                '}';
    }

    @Override
    public int compareTo(final Vertex vertex) {
        return Integer.compare(this.getLabel(), vertex.getLabel());
    }
}
