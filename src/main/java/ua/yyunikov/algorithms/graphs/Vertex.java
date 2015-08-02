package ua.yyunikov.algorithms.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * Representation of vertex for graph.
 */
public class Vertex {

    private final int label;

    private final Set<Edge> edges = new HashSet<>();

    /**
     * Constructor.
     *
     * @param label label for vertex
     */
    public Vertex(final int label) {
        this.label = label;
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
    public Edge getEdgeTo(final Vertex v2) {
        for (final Edge edge : edges) {
            if(edge.contains(this, v2)) {
                return edge;
            }
        }

        return null;
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
}
