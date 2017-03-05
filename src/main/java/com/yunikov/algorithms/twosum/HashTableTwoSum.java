package com.yunikov.algorithms.twosum;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Variation of two-sum algorithm by inserting elements of the array into hash table and performing lookup of sum in hash table.
 * Running time is O(n) for each of two steps of this algorithm.
 */
public class HashTableTwoSum extends TwoSumAlgorithm {

    /**
     * See {@link #twoSumExists(Map, long, boolean)}.
     */
    public boolean twoSumExists(final Map<Integer, Integer> map, final int sum, final boolean distinct) {
        for (int element: map.keySet()) {
            final Optional<Integer> lookedElement = Optional.ofNullable(map.get(sum - element));
            if (distinct && lookedElement.isPresent() && lookedElement.get() != element) {
                return true;
            } else if (!distinct && map.containsKey(sum - element)) {
                return true;
            }
        }

        return false;
    }


    /**
     * Checks if there are two numbers x,y as keys in the input map that satisfies x + y = sum.
     *
     * @param map input map for the algorithm
     * @param sum sum of two keys to look for
     * @return true if sum exists in the map, false otherwise
     */
    public boolean twoSumExists(final Map<Long, Long> map, final long sum, final boolean distinct) {
        for (long element: map.keySet()) {
            final Optional<Long> lookedElement = Optional.ofNullable(map.get(sum - element));
            if (distinct && lookedElement.isPresent() && lookedElement.get() != element) {
                return true;
            } else if (!distinct && map.containsKey(sum - element)) {
                return true;
            }
        }

        return false;
    }

    @Override
    protected boolean doTwoSumExists(final int[] array, final int sum, final boolean distinct) {
        final Map<Integer, Integer> hashMap = new HashMap<>(array.length);
        for (int element: array) {
            hashMap.put(element, element);
        }

        return twoSumExists(hashMap, sum, distinct);
    }

    @Override
    protected boolean doTwoSumExists(final long[] array, final long sum, final boolean distinct) {
        final Map<Long, Long> hashMap = new HashMap<>(array.length);
        for (long element: array) {
            hashMap.put(element, element);
        }

        return twoSumExists(hashMap, sum, distinct);
    }
}
