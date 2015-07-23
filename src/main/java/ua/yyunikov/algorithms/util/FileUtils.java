package ua.yyunikov.algorithms.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface FileUtils {

    static int[][] twoDimensionalArray(final String relPath) throws IOException {
        final Map<Integer, List<Integer>> lines = new LinkedHashMap<>();
        final FileReader reader = new FileReader(relPath);
        final BufferedReader br = new BufferedReader(reader);

        String line;
        while((line = br.readLine()) != null) {
            final String[] split = line.trim().split("(\\s)+");
            final List<Integer> adjList = new ArrayList<>();

            for(int i = 1; i < split.length; i++) {
                adjList.add(Integer.parseInt(split[i]) - 1);
            }

            lines.put(Integer.parseInt(split[0]) - 1, adjList);
        }

        final int[][] array = new int[lines.size()][];

        for (final Map.Entry<Integer, List<Integer>> entry : lines.entrySet() ) {
            final List<Integer> adjList = entry.getValue();
            final int[] adj = new int[adjList.size()];

            for(int i = 0; i < adj.length; i++) {
                adj[i] = adjList.get(i);
            }

            array[entry.getKey()] = adj;
        }

        return array;
    }
}
