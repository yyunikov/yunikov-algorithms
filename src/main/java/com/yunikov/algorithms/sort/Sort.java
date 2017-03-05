package com.yunikov.algorithms.sort;

/**
 * Abstract class for different kind of sorting algorithms.
 */
public abstract class Sort {

    /**
     * Sort array with specific algorithm.
     *
     * @param array array to sort
     */
    public void sort(final int[] array) {
        if (array.length == 0 || array.length == 1) {
            return;
        }

        doSort(array);
    }

    protected abstract void doSort(final int[] array);
}
