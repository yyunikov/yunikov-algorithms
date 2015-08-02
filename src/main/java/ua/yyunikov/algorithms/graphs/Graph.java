package ua.yyunikov.algorithms.graphs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Representation of a graph.
 */
public class Graph<T> {

    private final Set<T> vertices = new HashSet<>();

    private final List<Edge<T>> edges = new ArrayList<>();

    /**
     * Creates the graph from two dimensional array.
     *
     * @param array array to create a graph from
     * @return created graph
     */
    public static Graph<Integer> create(int[][] array) {
        final Graph<Integer> graph = new Graph<>();

        for (int i = 0; i < array.length; i++) {
            final Integer currentVertex = graph.getVertexOrAdd(i);

            for (int edgeTo : array[i]) {
                final Integer secondVertex = graph.getVertexOrAdd(edgeTo);
                final Optional<Edge<Integer>> edgeOptional = graph.getEdge(secondVertex, currentVertex);

                if(!edgeOptional.isPresent()) {
                    createEdge(graph, currentVertex, secondVertex);
                }
            }
        }

        return graph;
    }

    private static Edge<Integer> createEdge(final Graph<Integer> graph, final Integer firstVertex, final Integer secondVertex) {
        final Edge<Integer> newEdge = new Edge<>(firstVertex, secondVertex);
        graph.getEdges().add(newEdge);
        return newEdge;
    }

    /**
     * Adds a vertex to a graph.
     *
     * @param vertex vertex to add
     */
    public void addVertex(final T vertex) {
        vertices.add(vertex);
    }

    /**
     * Gets the vertex or add the new vertex with such label if it is not found.
     *
     * @param vertexToFind vertex to get or add
     * @return vertex with specified label
     */
    public T getVertexOrAdd(final T vertexToFind) {
        for (final T vertex: vertices) {
            if (Objects.equals(vertexToFind, vertex)) {
                return vertex;
            }
        }

        addVertex(vertexToFind);
        return vertexToFind;
    }

    public Optional<Edge<T>> getEdge(final T from, final T to) {
        for (final Edge<T> edge: edges) {
            if (edge.hasEnds(from, to)) {
                return Optional.of(edge);
            }
        }

        return Optional.empty();
    }

    public List<Edge<T>> getVertexEdges(final T vertex) {
        return edges.stream().filter(edge -> edge.getEnds().contains(vertex)).collect(Collectors.toList());
    }

    /**
     * Gets the list of graph edges.
     *
     * @return list of graph edges
     */
    public List<Edge<T>> getEdges() {
        return edges;
    }

    /**
     * Gets the set of graph vertices.
     *
     * @return set of graph vertices
     */
    public Set<T> getVertices() {
        return vertices;
    }
}
