package ua.yyunikov.algorithms;

import ua.yyunikov.algorithms.sort.QuickSort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        try {
            final int[] array = Files.lines(Paths.get("src/main/java/ua/yyunikov/algorithms/QuickSort.txt"))
                    .mapToInt(Integer::valueOf).toArray();
            final QuickSort quickSort = new QuickSort();
            quickSort.sort(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
