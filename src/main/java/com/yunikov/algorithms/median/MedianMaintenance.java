package com.yunikov.algorithms.median;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Abstract class for median maintenance algorithms for finding median-th smallest element of numbers one-by-one.
 * So, e.g. for list of 13 elements it should find the 6th smallest, for 14 elements, the 7th smallest and so on.
 */
public abstract class MedianMaintenance {

    /**
     * Finds the list of medians from the list of elements increasing it from 1 to n.
     * So, e.g. for list of 13 elements it should find the 6th smallest, for 14 elements, the 7th smallest and so on.
     * For odd numbers it will find the ((k+1)/2)th smallest number among x1,...,xk.
     * Fo even numbers it will find the (k/2)th smallest number among x1,...,xk.
     *
     * @param elements list of elements for the algorithm
     * @return list of medians
     */
    public List<Integer> findOneByOne(final List<Integer> elements) {
        if (elements == null || elements.isEmpty()) {
            return new ArrayList<>();
        }
        if (elements.size() == 1 || elements.size() == 2) {
            return new ArrayList<>(Collections.singletonList(elements.get(0)));
        }

        return doFindOneByOne(elements);
    }

    protected abstract List<Integer> doFindOneByOne(final List<Integer> elements);
}
