package ua.yyunikov.algorithms.inversions;

/**
 * Brute force algorithm for counting number of inversions in array by straight forward looping though all array elements.
 * Running time is O(n^2).
 */
public class BruteForceInversionsCount extends InversionsCount {

    @Override
    protected long doCount(final int[] array) {
        long count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
