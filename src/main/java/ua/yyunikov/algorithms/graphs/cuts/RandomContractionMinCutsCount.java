package ua.yyunikov.algorithms.graphs.cuts;

import org.apache.commons.lang3.ArrayUtils;
import ua.yyunikov.algorithms.graphs.Edge;
import ua.yyunikov.algorithms.util.RandomUtils;

public class RandomContractionMinCutsCount extends MinCutsCount {

    @Override
    protected int doCount(final int[][] graphArray) {
        final Edge edge = chooseRandomEdge(graphArray);
        final int[][] changedGraphArray = removeEdge(graphArray, edge);
        if (changedGraphArray.length == 2) {
            return changedGraphArray[0].length - 1;
        } else {
            return doCount(changedGraphArray);
        }
    }

    private Edge chooseRandomEdge(final int[][] graphArray) {
        final int vertex1 = RandomUtils.randomInt(1, graphArray.length);
        final int[] vertex1Connections = graphArray[vertex1 - 1];
        return new Edge(vertex1, RandomUtils.randomFromArray(vertex1Connections, 1));
    }

    private int[][] removeEdge(final int[][] graphArray, final Edge edge) {
        // always -1 because first element always represents vertex number starting from 1
        final int vertex1Index = edge.getVertex1() - 1;

        for (int i = 1; i < graphArray[vertex1Index].length; i++) {
            final int vertex2Index = edge.getVertex2() - 1;

            if (i != vertex2Index) {
                final int newElement = graphArray[vertex1Index][i];
                graphArray[vertex2Index] = ArrayUtils.add(graphArray[vertex2Index], newElement);
                if (newElement - 1 != vertex2Index) {
                    graphArray[newElement - 1] = ArrayUtils.add(graphArray[newElement - 1], edge.getVertex2());
                }
            }
        }

        // clean circular vertexes and removed vertex entries
        for (int i = 0; i < graphArray.length; i++) {
            for (int j = 1; j < graphArray[i].length; j++) {
                if (edge.getVertex1() == graphArray[i][j] || graphArray[i][0] == graphArray[i][j]) {
                    graphArray[i] = ArrayUtils.remove(graphArray[i], j);
                    j--;
                    continue;
                }
                if (graphArray[i][j] > edge.getVertex1()) {
                    graphArray[i][j] -= 1;
                }
            }

            if (graphArray[i][0] > edge.getVertex1()) {
                graphArray[i][0] -= 1;
            }
        }

        return ArrayUtils.remove(graphArray, vertex1Index);
    }
}
