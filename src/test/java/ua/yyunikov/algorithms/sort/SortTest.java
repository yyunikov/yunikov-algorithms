package ua.yyunikov.algorithms.sort;

import ua.yyunikov.algorithms.AlgorithmTest;

import java.util.Arrays;

public abstract class SortTest extends AlgorithmTest {

    protected abstract void testSort(final Sort sort);

    protected static int[] javaSort(final int[] array) {
        final int[] copy = array.clone();
        Arrays.sort(copy);
        return copy;
    }
}
