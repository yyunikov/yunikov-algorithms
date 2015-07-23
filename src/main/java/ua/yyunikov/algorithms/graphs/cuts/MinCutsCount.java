package ua.yyunikov.algorithms.graphs.cuts;

import ua.yyunikov.algorithms.graphs.Graph;

public abstract class MinCutsCount {

    public int count(final Graph graph) {
        if (graph.getEdges().size() == 0) {
            return 0;
        }
        if (graph.getEdges().size() == 1) {
            return 1;
        }

        return doCount(graph);
    }

    public int count(final int[][] graphArray) {
        return doCount(Graph.createGraph(graphArray));
    }

    protected abstract int doCount(final Graph graph);
}
