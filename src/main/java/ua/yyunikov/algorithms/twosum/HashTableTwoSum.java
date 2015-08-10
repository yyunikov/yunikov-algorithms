package ua.yyunikov.algorithms.twosum;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Variation of two-sum algorithm by inserting elements of the array into hash table and performing lookup of sum in hash table.
 * Running time is O(n) for each of two steps of this algorithm.
 */
public class HashTableTwoSum extends TwoSumAlgorithm {

    @Override
    protected boolean doTwoSumExists(final int[] array, final int sum, final boolean distinct) {
        final Map<Integer, Integer> hashMap = new HashMap<>(array.length);
        for (int element: array) {
            hashMap.put(element, element);
        }
        for (int element: array) {
            final Optional<Integer> lookedElement = Optional.ofNullable(hashMap.get(sum - element));
            if (distinct && lookedElement.isPresent() && lookedElement.get() != element) {
                return true;
            } else if (!distinct && hashMap.containsKey(sum - element)) {
                return true;
            }
        }

        return false;
    }

    @Override
    protected boolean doTwoSumExists(final long[] array, final long sum, final boolean distinct) {
        final Map<Long, Long> hashMap = new HashMap<>(array.length);
        for (long element: array) {
            hashMap.put(element, element);
        }
        for (long element: array) {
            final Optional<Long> lookedElement = Optional.ofNullable(hashMap.get(sum - element));
            if (distinct && lookedElement.isPresent() && lookedElement.get() != element) {
               return true;
            } else if (!distinct && hashMap.containsKey(sum - element)) {
                return true;
            }
        }

        return false;
    }
}
