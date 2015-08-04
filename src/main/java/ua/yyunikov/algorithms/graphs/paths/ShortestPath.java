package ua.yyunikov.algorithms.graphs.paths;

import ua.yyunikov.algorithms.graphs.Graph;
import ua.yyunikov.algorithms.graphs.Vertex;

/**
 * Abstract class for algorithms for finding <a href="https://en.wikipedia.org/wiki/Shortest_path_problemt">shortest paths</a> in the graph.
 */
public abstract class ShortestPath {

    /**
     * Finds shortest path from vertex to vertex.
     *
     * @param graph graph for finding shortest paths
     * @return minimum cuts count
     */
    public int findShortestPath(final Graph graph, final Vertex from, final Vertex to) {
        if (graph.getEdges().size() == 0) {
            return 0;
        }

        return doFind(graph, from, to);
    }

    protected abstract int doFind(final Graph graph, final Vertex from, final Vertex to);
}
