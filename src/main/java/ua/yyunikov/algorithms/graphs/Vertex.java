package ua.yyunikov.algorithms.graphs;

import java.util.HashSet;
import java.util.Set;

public class Vertex {

    private final int label;

    private final Set<Edge> edges = new HashSet<>();

    public Vertex(final int label) {
        this.label = label;
    }

    public void addEdge(final Edge edge) {
        edges.add(edge);
    }

    public Edge getEdgeTo(final Vertex v2) {
        for (final Edge edge : edges) {
            if(edge.contains(this, v2)) {
                return edge;
            }
        }

        return null;
    }

    public int getLabel() {
        return label;
    }

    public Set<Edge> getEdges() {
        return edges;
    }
}
