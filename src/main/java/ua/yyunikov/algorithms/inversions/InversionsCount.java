package ua.yyunikov.algorithms.inversions;

/**
 * Abstract class for algorithms for counting <a href="https://en.wikipedia.org/wiki/Inversion_(discrete_mathematics)">inversions</a>.
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

        return doCount(array.clone());
    }

    protected abstract long doCount(final int[] array);

    /**
     * Computes a maximum count of inversions for an array of size arraySize.
     *
     * @param arraySize size of array
     * @return maximum count of inversions for an array of size arraySize
     */
    public static int largestCount(final int arraySize) {
        return arraySize*(arraySize - 1) / 2;
    }
}
