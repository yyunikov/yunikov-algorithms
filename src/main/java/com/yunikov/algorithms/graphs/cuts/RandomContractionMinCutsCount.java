package com.yunikov.algorithms.graphs.cuts;

import com.yunikov.algorithms.graphs.Edge;
import com.yunikov.algorithms.graphs.Vertex;
import com.yunikov.algorithms.graphs.Graph;

import java.util.Iterator;
import java.util.Random;

/**
 * <a href="https://en.wikipedia.org/wiki/Karger%27s_algorithm">Randomized contraction algorithm</> for counting number of minimum cuts.
 * The value may differ depending on the execution as this is a randomized algorithm.
 * It is recommended to run the algorithm multiple times (e.g. can be n times if n - is a number of vertices)
 */
public class RandomContractionMinCutsCount extends MinCutsCount {

    @Override
    protected int doCount(final Graph graph) {
        while(graph.getVertices().size() > 2) {
            final int randomEdgeIndex = new Random().nextInt(graph.getEdges().size());
            final Edge edge = graph.getEdges().remove(randomEdgeIndex);
            final Vertex v1 = cleanVertex(graph, edge.getEnds().get(0), edge);
            final Vertex v2 = cleanVertex(graph, edge.getEnds().get(1), edge);

            final Vertex mergedVertex = new Vertex(v1.getLabel());
            redirectEdges(graph, v1, mergedVertex);
            redirectEdges(graph, v2, mergedVertex);

            graph.addVertex(mergedVertex);
        }

        return graph.getEdges().size();
    }

    private Vertex cleanVertex(final Graph graph, final Vertex vertex, final Edge edge) {
        graph.getVertices().remove(vertex.getLabel());
        vertex.getEdges().remove(edge);

        return vertex;
    }

    private void redirectEdges(final Graph graph, final Vertex fromVertex, final Vertex toVertex) {
        for (final Iterator<Edge> it = fromVertex.getEdges().iterator(); it.hasNext();) {
            final Edge edge = it.next();
            it.remove();

            if (edge.getOppositeVertex(fromVertex) == toVertex) {
                toVertex.getEdges().remove(edge);
                graph.getEdges().remove(edge);
            } else {
                edge.replaceVertex(fromVertex, toVertex);
                toVertex.addEdge(edge);
            }
        }
    }
}
