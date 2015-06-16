package ua.yyunikov.algorithms.inversions;

import ua.yyunikov.algorithms.util.ArrayUtils;

/**
 * Divide and conquer inversions count algorithm for counting the number of inversions in array.
 * Algorithm is similar to the merge sort algorithm. Running time is n*log(n).
 */
public class DivideConquerInversionsCount extends InversionsCount {

    @Override
    protected long doCount(final int[] array) {
        if (array.length < 2) {
            return 0;
        }

        final int[][] splittedArray = ArrayUtils.split(array);
        final int[] leftPart = splittedArray[0];
        final int[] rightPart = splittedArray[1];

        return doCount(leftPart) + doCount(rightPart) + countSplitInversions(leftPart, rightPart);
    }

    private long countSplitInversions(final int[] leftPart, final int[] rightPart) {
        final int fullLength = leftPart.length + rightPart.length;

        long count = 0;
        int leftPartCounter = 0;
        int rightPartCounter = 0;

        for (int loopCounter = 0; loopCounter < fullLength; loopCounter++) {
            // rightPartCounter can exceed the right part length so if yes, we just add all from the left part
            if (rightPartCounter >= rightPart.length || leftPartCounter < leftPart.length && leftPart[leftPartCounter] < rightPart[rightPartCounter]) {
                count += leftPart.length - leftPartCounter - 1;
                leftPartCounter++;
            } else { // leftPartCounter can exceed the left part length so if yes, we just add all from the right part
                rightPartCounter++;
            }
        }

        return count;
    }
}
