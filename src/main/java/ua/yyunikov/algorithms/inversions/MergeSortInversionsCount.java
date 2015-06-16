package ua.yyunikov.algorithms.inversions;

import ua.yyunikov.algorithms.util.ArrayUtils;

/**
 * Merge sort inversions count algorithm for counting the number of inversions in array.
 * Algorithm is similar to the merge sort algorithm. Running time is n*log(n).
 */
public class MergeSortInversionsCount extends InversionsCount {

    @Override
    protected long doCount(final int[] array) {
        if (array.length < 2) {
            return 0;
        }

        final int[][] splittedArray = ArrayUtils.split(array);
        final int[] leftPart = splittedArray[0];
        final int[] rightPart = splittedArray[1];

        return doCount(leftPart) + doCount(rightPart) + mergeAndCountSplitInversions(array, leftPart, rightPart);
    }

    private long mergeAndCountSplitInversions(final int[] array, final int[] leftPart, final int[] rightPart) {
        final int fullLength = leftPart.length + rightPart.length;

        int count = 0;
        int leftPartCounter = 0;
        int rightPartCounter = 0;

        for (int loopCounter = 0; loopCounter < fullLength; loopCounter++) {
            // rightPartCounter can exceed the right part length so if yes, we just add all from the left part
            if (rightPartCounter >= rightPart.length || leftPartCounter < leftPart.length && leftPart[leftPartCounter] < rightPart[rightPartCounter]) {
                array[loopCounter] = leftPart[leftPartCounter];
                leftPartCounter++;
            } else { // leftPartCounter can exceed the left part length so if yes, we just add all from the right part
                count += leftPart.length - leftPartCounter;
                array[loopCounter] = rightPart[rightPartCounter];
                rightPartCounter++;
            }
        }

        return count;
    }
}
