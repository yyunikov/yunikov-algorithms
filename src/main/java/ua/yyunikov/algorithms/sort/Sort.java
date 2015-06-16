package ua.yyunikov.algorithms.sort;

/**
 * Abstract class for different kind of sorting algorithms.
 */
public abstract class Sort {

    /**
     * Sort array with specific algorithm.
     *
     * @param array array to sort
     * @return sorted array
     */
    public int[] sort(final int[] array) {
        if (array.length == 0 || array.length == 1) {
            return array;
        }

        return doSort(array);
    }

    protected abstract int[] doSort(final int[] array);
}
