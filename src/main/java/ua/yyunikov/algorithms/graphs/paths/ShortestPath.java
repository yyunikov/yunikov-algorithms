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

    /**
     * Counts the number of minimum cuts in the graph.
     *
     * @param graphArray graph representation in two dimensional array
     * @return minimum cuts count
     */
    public int findShortestPath(final int[][] graphArray, final int from, final int to) {
        return doFind(Graph.createGraph(graphArray), new Vertex(from), new Vertex(to));
    }

    protected abstract int doFind(final Graph graph, final Vertex from, final Vertex to);
}
