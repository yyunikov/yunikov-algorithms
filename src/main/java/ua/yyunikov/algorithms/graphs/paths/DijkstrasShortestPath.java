package ua.yyunikov.algorithms.graphs.paths;

import ua.yyunikov.algorithms.graphs.Edge;
import ua.yyunikov.algorithms.graphs.Graph;
import ua.yyunikov.algorithms.graphs.Vertex;

import java.util.*;

/**
 * <a href="https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm">Dijkstra's shortest path</a> algorithm for the graph.
 * Running time is O(m*log(n)), where n - number of vertices, m - number of edges.
 */
public class DijkstrasShortestPath extends ShortestPath {

    @Override
    protected int doFind(final Graph graph, final Vertex from, final Vertex to) {
        final List<Vertex> processedVertices = new ArrayList<>(Collections.singletonList(from));
        final Map<Vertex, Integer> vertexShortestPaths = new TreeMap<>(Vertex::compareTo);
        vertexShortestPaths.put(from, 0);

        while(processedVertices.size() != graph.getVertices().size()) {
            processMinScoreVertex(vertexShortestPaths, processedVertices);
        }

        return vertexShortestPaths.get(to);
    }

    private void processMinScoreVertex(final Map<Vertex, Integer> vertexShortestPaths, final List<Vertex> processedVertices) {
        final PriorityQueue<EdgeScorePair> currentGreedyScores = createCurrentGreedyScores(vertexShortestPaths, processedVertices);
        final EdgeScorePair minGreedyScore = currentGreedyScores.peek();

        final Vertex processed = findProcessedVertex(minGreedyScore.getEdge(), processedVertices);
        final Vertex nonProcessed = minGreedyScore.getEdge().getOppositeVertex(processed);

        vertexShortestPaths.put(nonProcessed, minGreedyScore.getScore());
        processedVertices.add(nonProcessed);
    }

    private PriorityQueue<EdgeScorePair> createCurrentGreedyScores(final Map<Vertex, Integer> vertexShortestPaths, final List<Vertex> processedVertices) {
        final PriorityQueue<EdgeScorePair> greedyScoresHeap = new PriorityQueue<>(EdgeScorePair::compareTo);

        for (final Vertex vertex: processedVertices) {
            for (final Edge vertexEdge: vertex.getEdges()) {
                final Vertex oppositeVertex = vertexEdge.getOppositeVertex(vertex);
                if (!processedVertices.contains(oppositeVertex)) {
                    greedyScoresHeap.add(new EdgeScorePair(vertexEdge, vertexShortestPaths.get(vertex) + vertexEdge.getWeight()));
                }
            }
        }

        return greedyScoresHeap;
    }

    private Vertex findProcessedVertex(final Edge edge, final List<Vertex> processedVertices) {
        final Vertex oneEnd = edge.getEnds().get(0);
        final Vertex secondEnd = edge.getEnds().get(1);
        if (processedVertices.contains(oneEnd)) {
            return oneEnd;
        }
        if (processedVertices.contains(secondEnd)) {
            return secondEnd;
        }

        throw new IllegalStateException("Edge should contain one non processed vertex");
    }

    private static class EdgeScorePair implements Comparable<EdgeScorePair> {
        private Edge edge;
        private int score;

        public EdgeScorePair(final Edge edge, final int score) {
            this.edge = edge;
            this.score = score;
        }

        public Edge getEdge() {
            return edge;
        }

        public int getScore() {
            return score;
        }

        @Override
        public int compareTo(final EdgeScorePair scorePair) {
            if (scorePair == null) {
                return 0;
            }

            return Integer.compare(this.getScore(), scorePair.getScore());
        }
    }
}
