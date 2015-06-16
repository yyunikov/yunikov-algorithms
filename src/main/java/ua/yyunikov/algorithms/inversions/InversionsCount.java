package ua.yyunikov.algorithms.inversions;

/**
 * Abstract class for algorithms for counting inversions.
 */
public abstract class InversionsCount {

    /**
     * Count number of inversions in array.
     *
     * @param array array to count inversions in
     * @return number of inversions
     */
    public long count(final int[] array) {
        if (array.length == 0 || array.length == 1) {
            return 0;
        }

        return doCount(array);
    }

    protected abstract long doCount(final int[] array);

    public static int largestCount(final int arraySize) {
        return arraySize*(arraySize - 1) / 2;
    }
}
