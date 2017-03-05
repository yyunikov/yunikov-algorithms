package com.yunikov.algorithms.search;

import java.util.Arrays;
import java.util.Optional;

/**
 * Implementation of <a href="https://en.wikipedia.org/wiki/Binary_search_algorithm">binary search algorithm in array</a>
 */
public class BinarySearch extends ArraySearch {

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Integer> searchSorted(final int[] array, final int key) {
        int from = 0;
        int to = array.length - 1;

        while (from <= to) {
            final int mid = (from + to) >>> 1; // equivalent to dividing by 2
            final long midVal = array[mid];

            if (midVal < key) {
                from = mid + 1;
            } else if (midVal > key) {
                to = mid - 1;
            } else {
                return Optional.of(mid);
            }
        }

        return Optional.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Long> searchSorted(final long[] array, final long key) {
        long from = 0;
        long to = array.length - 1;

        while (from <= to) {
            final long mid = ((from + to) >>> 1); // equivalent to dividing by 2
            final long midVal = array[((int) mid)];

            if (midVal < key) {
                from = mid + 1;
            } else if (midVal > key) {
                to = mid - 1;
            } else {
                return Optional.of(mid);
            }
        }

        return Optional.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Integer> search(final int[] array, final int key) {
        final int[] arrayCopy = Arrays.copyOf(array, array.length);
        Arrays.sort(arrayCopy);
        return searchSorted(arrayCopy, key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Long> search(final long[] array, final long key) {
        final long[] arrayCopy = Arrays.copyOf(array, array.length);
        Arrays.sort(arrayCopy);
        return searchSorted(arrayCopy, key);
    }
}
