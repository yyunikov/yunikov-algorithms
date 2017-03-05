package com.yunikov.algorithms.graphs.search;

import com.yunikov.algorithms.graphs.Edge;
import com.yunikov.algorithms.graphs.Vertex;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;

/**
 * <a href="https://en.wikipedia.org/wiki/Depth-first_search">Depth first search</a> algorithm for the graph.
 * Running time is O(m + n), where n - number of vertices, m - number of edges.
 */
public class DepthFirstSearch extends GraphSearch {

    @Override
    protected Optional<Vertex> doSearch(final Vertex startVertex, final int label) {
        final Set<Vertex> explored = new HashSet<>();
        final Stack<Vertex> stack = new Stack<>();
        stack.add(startVertex);

        while (!stack.isEmpty()) {
            final Vertex currentVertex = stack.pop();
            if (currentVertex.getLabel() == label) {
                return Optional.of(currentVertex);
            }

            if (!explored.contains(currentVertex)) {
                explored.add(currentVertex);

                for (final Edge edge: currentVertex.getEdges()) {
                    stack.push(edge.getOppositeVertex(currentVertex));
                }
            }
        }

        return Optional.empty();
    }
}
