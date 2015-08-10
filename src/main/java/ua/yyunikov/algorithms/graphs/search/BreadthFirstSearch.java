package ua.yyunikov.algorithms.graphs.search;

import ua.yyunikov.algorithms.graphs.Edge;
import ua.yyunikov.algorithms.graphs.Vertex;

import java.util.*;

/**
 * <a href="https://en.wikipedia.org/wiki/Breadth-first_search">Breadth first search</a> algorithm for the graph.
 * Running time is O(m + n), where n - number of vertices, m - number of edges.
 */
public class BreadthFirstSearch extends GraphSearch {

    @Override
    protected Optional<Vertex> doSearch(final Vertex startVertex, final int label) {
        final Set<Vertex> explored = new HashSet<>();
        final Queue<Vertex> vertexQueue = new LinkedList<>();
        vertexQueue.add(startVertex);
        explored.add(startVertex);

        while (!vertexQueue.isEmpty()) {
            final Vertex currentVertex = vertexQueue.poll();

            for (final Edge edge: currentVertex.getEdges()) {
                final Vertex oppositeVertex = edge.getOppositeVertex(currentVertex);
                if (oppositeVertex.getLabel() == label) {
                    return Optional.of(oppositeVertex);
                }

                if (!explored.contains(oppositeVertex)) {
                    explored.add(oppositeVertex);
                    vertexQueue.add(oppositeVertex);
                }
            }

        }

        return Optional.empty();
    }
}
