package ua.yyunikov.algorithms.sort;

import ua.yyunikov.algorithms.util.ArrayUtils;

/**
 * <a href="https://en.wikipedia.org/wiki/Bubble_sort">Bubble sort</a> algorithm. Running time of n^2.
 */
public class BubbleSort extends Sort {

    @Override
    protected int[] doSort(final int[] array) {
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    ArrayUtils.swap(array, i- 1,i);
                    swapped = true;
                }
            }
        } while (swapped);

        return array;
    }
}
