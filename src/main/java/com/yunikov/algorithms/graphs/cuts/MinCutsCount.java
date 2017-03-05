package com.yunikov.algorithms.graphs.cuts;

import com.yunikov.algorithms.graphs.Graph;

/**
 * Abstract class for algorithms for counting <a href="https://en.wikipedia.org/wiki/Minimum_cut">minimum cuts</a> in the graph.
 */
public abstract class MinCutsCount {

    /**
     * Counts the number of minimum cuts in the graph.
     *
     * @param graph graph for counting minimum cuts
     * @return minimum cuts count
     */
    public int count(final Graph graph) {
        if (graph.getEdges().size() == 0) {
            return 0;
        }
        if (graph.getEdges().size() == 1) {
            return 1;
        }

        return doCount(graph);
    }

    /**
     * Counts the number of minimum cuts in the graph.
     *
     * @param graphArray graph representation in two dimensional array
     * @return minimum cuts count
     */
    public int count(final int[][] graphArray) {
        return doCount(Graph.createGraph(graphArray));
    }

    protected abstract int doCount(final Graph graph);
}
