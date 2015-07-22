package ua.yyunikov.algorithms.graphs.cuts;

public abstract class MinCutsCount {

    public int count(final int[][] graphArray) {
        if (graphArray.length == 0 || graphArray.length == 1) {
            return 0;
        }

        if (graphArray.length == 2) {
            return graphArray[0].length;
        }

        return doCount(graphArray);
    }

    protected abstract int doCount(final int[][] graphArray);
}
