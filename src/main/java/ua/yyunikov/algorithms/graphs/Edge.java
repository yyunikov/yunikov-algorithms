package ua.yyunikov.algorithms.graphs;

import java.util.ArrayList;
import java.util.List;

public class Edge {

    private final List<Vertex> ends = new ArrayList<>();

    public Edge(final Vertex v1, final Vertex v2) {
        if (v1 == null || v2 == null) {
            throw new IllegalArgumentException("Both vertices are required");
        }

        ends.add(v1);
        ends.add(v2);
    }

    public boolean contains(final Vertex v1, final Vertex v2) {
        return ends.contains(v1) && ends.contains(v2);
    }

    public Vertex getOppositeVertex(final Vertex v) {
        if (!ends.contains(v)) {
            throw new IllegalArgumentException("Vertex " + v.getLabel());
        }

        return ends.get(1 - ends.indexOf(v));
    }

    public void replaceVertex(final Vertex oldVertex, final Vertex newVertex) {
        if (!ends.contains(oldVertex)) {
            throw new IllegalArgumentException("Vertex " + oldVertex.getLabel());
        }

        ends.remove(oldVertex);
        ends.add(newVertex);
    }

    public List<Vertex> getEnds() {
        return ends;
    }
}
