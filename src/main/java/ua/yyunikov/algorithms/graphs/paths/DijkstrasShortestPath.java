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
        final Map<Edge, Integer> currentGreedyScores = createCurrentGreedyScores(vertexShortestPaths, processedVertices);
        final int minGreedyScore = Collections.min(currentGreedyScores.values());

        for (final Map.Entry<Edge, Integer> entry: currentGreedyScores.entrySet()) {
            if (entry.getValue() == minGreedyScore) {
                final Vertex processed = findProcessedVertex(entry.getKey(), processedVertices);
                final Vertex nonProcessed = entry.getKey().getOppositeVertex(processed);
                final int edgeScore = entry.getValue();

                vertexShortestPaths.put(nonProcessed, edgeScore);
                processedVertices.add(nonProcessed);
                return;
            }
        }

        throw new IllegalStateException("Can't find vertex by the minimum greedy score");
    }

    private Map<Edge, Integer> createCurrentGreedyScores(final Map<Vertex, Integer> vertexShortestPaths, final List<Vertex> processedVertices) {
        final Map<Edge, Integer> currentGreedyScores = new HashMap<>();

        for (final Vertex vertex: processedVertices) {
            for (final Edge vertexEdge: vertex.getEdges()) {
                final Vertex oppositeVertex = vertexEdge.getOppositeVertex(vertex);
                if (!processedVertices.contains(oppositeVertex)) {
                    currentGreedyScores.put(vertexEdge, vertexShortestPaths.get(vertex) + vertexEdge.getWeight());
                }
            }
        }

        return currentGreedyScores;
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
}
