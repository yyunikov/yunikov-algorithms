package ua.yyunikov.algorithms.graphs.search;

import ua.yyunikov.algorithms.graphs.Graph;
import ua.yyunikov.algorithms.graphs.Vertex;

import java.util.Optional;

/**
 * Abstract class of algorithms for <a href="https://en.wikipedia.org/wiki/Graph_traversal">graph search (traversal)</a>.
 */
public abstract class GraphSearch {

    public Optional<Vertex> search(final Vertex startVertex, final int label) {
        if (startVertex.getLabel() == label) {
            return Optional.of(startVertex);
        }

        return doSearch(startVertex, label);
    }

    public Optional<Vertex> search(final Graph graph, final int label) {
        if (graph.getVertices().values().iterator().hasNext()) {
            final Vertex startVertex = graph.getVertices().values().iterator().next();
            return search(startVertex, label);
        }

        return Optional.empty();
    }

    public Optional<Vertex> search(final Graph graph, final Vertex vertex) {
        return search(graph, vertex.getLabel());
    }

    protected abstract Optional<Vertex> doSearch(final Vertex startVertex, final int label);
}
