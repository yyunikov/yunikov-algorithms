package ua.yyunikov.algorithms.graphs.cuts;

import ua.yyunikov.algorithms.graphs.Edge;
import ua.yyunikov.algorithms.graphs.Graph;
import ua.yyunikov.algorithms.graphs.Vertex;

import java.util.Iterator;
import java.util.Random;

public class RandomContractionMinCutsCount extends MinCutsCount {

    @Override
    protected int doCount(final Graph graph) {
        final Random random = new Random(System.currentTimeMillis());

        while(graph.getVertices().size() > 2) {
            final Edge edge = graph.getEdges().remove(random.nextInt(graph.getEdges().size()));
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
        for (final Iterator<Edge> it = fromVertex.getEdges().iterator(); it.hasNext(); ) {
            final Edge edge = it.next();
            it.remove();

            if (edge.getOppositeVertex( fromVertex ) == toVertex) {
                //remove self-loop
                toVertex.getEdges().remove( edge );
                graph.getEdges().remove( edge );
            } else {
                edge.replaceVertex( fromVertex, toVertex );
                toVertex.addEdge(edge);
            }
        }
    }
}
