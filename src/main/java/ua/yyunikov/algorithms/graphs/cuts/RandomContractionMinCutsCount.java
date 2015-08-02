package ua.yyunikov.algorithms.graphs.cuts;

import ua.yyunikov.algorithms.graphs.Edge;
import ua.yyunikov.algorithms.graphs.Graph;

import java.util.Iterator;
import java.util.Objects;
import java.util.Random;

/**
 * <a href="https://en.wikipedia.org/wiki/Karger%27s_algorithm">Randomized contraction algorithm</> for counting number of minimum cuts.
 * The value may differ depending on the execution as this is a randomized algorithm.
 * It is recommended to run the algorithm multiple times (e.g. can be n times if n - is a number of vertices)
 */
public class RandomContractionMinCutsCount extends MinCutsCount {

    @Override
    protected int doCount(final Graph<Integer> graph) {
        final Random random = new Random(System.currentTimeMillis());

        while(graph.getVertices().size() > 2) {
            final Edge<Integer> edge = graph.getEdges().remove(random.nextInt(graph.getEdges().size()));
            final Integer v1 = cleanVertex(graph, edge.getEnds().get(0));
            final Integer v2 = cleanVertex(graph, edge.getEnds().get(1));

            redirectEdges(graph, v1, v1);
            redirectEdges(graph, v2, v1);

            graph.addVertex(v1);
        }

        return graph.getEdges().size();
    }

    private Integer cleanVertex(final Graph<Integer> graph, final Integer vertex) {
        graph.getVertices().remove(vertex);
        return vertex;
    }

    private void redirectEdges(final Graph<Integer> graph, final Integer fromVertex, final Integer toVertex) {
        for (final Iterator<Edge<Integer>> it = graph.getVertexEdges(fromVertex).iterator(); it.hasNext();) { // get edges only from fromVertex
            final Edge<Integer> edge = it.next();
            it.remove();

            if (Objects.equals(edge.getOppositeVertex(fromVertex), toVertex)) {
                graph.getEdges().remove(edge);
            } else {
                edge.replaceVertex(fromVertex, toVertex);
            }
        }
    }
}
