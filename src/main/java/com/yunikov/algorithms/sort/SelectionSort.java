package com.yunikov.algorithms.sort;

import com.yunikov.algorithms.util.ArrayUtils;

/**
 * <a href="https://en.wikipedia.org/wiki/Selection_sort">Selection sort</a> algorithm. Running time is O(n^2).
 */
public class SelectionSort extends Sort {

    @Override
    protected void doSort(final int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int iMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[iMin]) {
                    iMin = j;
                }
            }

            if (iMin != i) {
                ArrayUtils.swap(array, i, iMin);
            }
        }
    }
}
