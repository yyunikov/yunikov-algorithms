package ua.yyunikov.algorithms;

import ua.yyunikov.algorithms.graphs.cuts.MinCutsCount;
import ua.yyunikov.algorithms.graphs.cuts.RandomContractionMinCutsCount;
import ua.yyunikov.algorithms.util.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        final int[][] array = FileUtils.twoDimensionalArray("src/main/java/ua/yyunikov/algorithms/kargerMinCut.txt");
        int minResult = Integer.MAX_VALUE;
        for (final int[] anArray : array) {
            final int result = countFromFile(array);
            if (result < minResult) {
                minResult = result;
            }
        }

        System.out.println(minResult);
    }

    private static int countFromFile(final int[][] array) throws IOException {
        final MinCutsCount minCutsCount = new RandomContractionMinCutsCount();
        return minCutsCount.count(array);
    }

    private static int[][] getArray(final String relPath) throws IOException {
        int i = 0;
        final int[][] array = new int[200][];
        final List<String> allLines = Files.readAllLines(Paths.get("src/main/java/ua/yyunikov/algorithms/kargerMinCut.txt"));

        for (final String line: allLines) {
            final String[] splittedLine = line.split("\t");
            final int[] lineArray = new int[splittedLine.length];
            for (int j = 0; j < splittedLine.length; j++) {
                lineArray[j] = Integer.valueOf(splittedLine[j]);
            }

            array[i] = Arrays.copyOf(lineArray, lineArray.length);
            i++;
        }

        return array;
    }
}
