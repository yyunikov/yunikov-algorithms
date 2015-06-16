package ua.yyunikov.algorithms.sort;

import ua.yyunikov.algorithms.util.ArrayUtils;

/**
 * <a href="https://en.wikipedia.org/wiki/Merge_sort">Merge sort</a> algorithm. Running time is n*log(n).
 */
public class MergeSort extends Sort {

    @Override
    protected int[] doSort(final int[] array) {
        if (array.length > 1) {
            final int[][] splittedArray = ArrayUtils.split(array);
            final int[] leftPart = doSort(splittedArray[0]);
            final int[] rightPart = doSort(splittedArray[1]);
            return merge(leftPart, rightPart);
        }

        return array;
    }

    private int[] merge(final int[] leftPart, final int[] rightPart) {
        final int fullLength = leftPart.length + rightPart.length;
        final int[] mergeResult = new int[fullLength];
        int leftPartCounter = 0;
        int rightPartCounter = 0;

        for (int loopCounter = 0; loopCounter < fullLength; loopCounter++) {
            // rightPartCounter can exceed the right part length so if yes, we just add all from the left part
            if (rightPartCounter >= rightPart.length || leftPartCounter < leftPart.length && leftPart[leftPartCounter] < rightPart[rightPartCounter]) {
                mergeResult[loopCounter] = leftPart[leftPartCounter];
                leftPartCounter++;
            } else { // leftPartCounter can exceed the left part length so if yes, we just add all from the right part
                mergeResult[loopCounter] = rightPart[rightPartCounter];
                rightPartCounter++;
            }
        }

        return mergeResult;
    }
}
