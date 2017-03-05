package com.yunikov.algorithms.twosum;

import com.yunikov.algorithms.search.BinarySearch;
import com.yunikov.algorithms.search.ArraySearch;

import java.util.Arrays;
import java.util.Optional;

/**
 * Variation of two-sum algorithm by sorting array and performing binary search on it.
 * Running time is O(n*log(n)) for each of two steps of this algorithm.
 */
public class BinarySearchTwoSum extends TwoSumAlgorithm {

    /**
     * Checks if there are two numbers x,y in the sorted input array that satisfies x + y = sum.
     *
     * @param array sorted input array for the algorithm
     * @param sum sum of two numbers to look for
     * @return true if
     */
    public boolean twoSumExistsSorted(final long[] array, final long sum, final boolean distinct) {
        final ArraySearch search = new BinarySearch();

        for (long element: array) {
            final long searchElement = sum - element;
            final Optional<Long> optElement = search.searchSorted(array, searchElement);
            if (distinct && optElement.isPresent() && array[(int)((long)optElement.get())] != element) {
                return true;
            } else if (!distinct && optElement.isPresent()) {
                return true;
            }
        }

        return false;
    }

    /**
     * See {@link #twoSumExistsSorted(long[], long, boolean)}
     */
    public boolean twoSumExistsSorted(final int[] array, final int sum, final boolean distinct) {
        final ArraySearch search = new BinarySearch();

        for (int element: array) {
            final int searchElement = sum - element;
            final Optional<Integer> optElement = search.searchSorted(array, searchElement);
            if (distinct && optElement.isPresent() && array[optElement.get()] != element) {
                return true;
            } else if (!distinct && optElement.isPresent()) {
                return true;
            }
        }

        return false;
    }

    @Override
    protected boolean doTwoSumExists(final int[] array, final int sum, final boolean distinct) {
        final int[] arrayCopy = Arrays.copyOf(array, array.length);
        Arrays.sort(arrayCopy);
        return twoSumExistsSorted(arrayCopy, sum, distinct);
    }

    @Override
    protected boolean doTwoSumExists(final long[] array, final long sum, final boolean distinct) {
        final long[] arrayCopy = Arrays.copyOf(array, array.length);
        Arrays.sort(arrayCopy);
        return twoSumExistsSorted(arrayCopy, sum, distinct);
    }
}
