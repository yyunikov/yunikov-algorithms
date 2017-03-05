package com.yunikov.algorithms.sort;

import com.yunikov.algorithms.util.ArrayUtils;

/**
 * <a href="https://en.wikipedia.org/wiki/Merge_sort">Merge sort</a> algorithm. Running time is O(n*log(n)).
 */
public class MergeSort extends Sort {

    @Override
    protected void doSort(final int[] array) {
        if (array.length > 1) {
            final int[][] splittedArray = ArrayUtils.split(array);

            doSort(splittedArray[0]);
            doSort(splittedArray[1]);
            merge(array, splittedArray[0], splittedArray[1]);
        }
    }

    private void merge(final int[] array, final int[] leftPart, final int[] rightPart) {
        final int fullLength = leftPart.length + rightPart.length;
        int leftPartCounter = 0;
        int rightPartCounter = 0;

        for (int loopCounter = 0; loopCounter < fullLength; loopCounter++) {
            // rightPartCounter can exceed the right part length so if yes, we just add all from the left part
            if (rightPartCounter >= rightPart.length || leftPartCounter < leftPart.length && leftPart[leftPartCounter] < rightPart[rightPartCounter]) {
                array[loopCounter] = leftPart[leftPartCounter];
                leftPartCounter++;
            } else { // leftPartCounter can exceed the left part length so if yes, we just add all from the right part
                array[loopCounter] = rightPart[rightPartCounter];
                rightPartCounter++;
            }
        }
    }
}
