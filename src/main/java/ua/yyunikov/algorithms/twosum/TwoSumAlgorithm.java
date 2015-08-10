package ua.yyunikov.algorithms.twosum;

/**
 * Abstract class for different kind of implementations for two-sum algorithm, one of variations of
 * <a href="https://en.wikipedia.org/wiki/Subset_sum_problem">subset sum problem<a/>.
 */
public abstract class TwoSumAlgorithm {

    /**
     * Checks if there are two numbers x,y in the input array that satisfies x + y = sum.
     *
     * @param array input array for the algorithm
     * @param sum sum of two numbers to look for
     * @return true if
     */
    public boolean twoSumExists(final long[] array, final long sum) {
        return twoSumExists(array, sum, false);
    }

    /**
     * Checks if there are two numbers x,y in the input array that satisfies x + y = sum.
     *
     * @param array input array for the algorithm
     * @param sum sum of two numbers to look for
     * @param distinct true if there should be two distinct numbers x,y, false otherwise
     * @return true if sum exists in the array, false otherwise
     */
    public boolean twoSumExists(final long[] array, final long sum, final boolean distinct) {
        return !(array.length == 0 || array.length == 1) && doTwoSumExists(array, sum, distinct);
    }

    /**
     * See {@link #twoSumExists(long[], long)}.
     */
    public boolean twoSumExists(final int[] array, final int sum) {
        return twoSumExists(array, sum, false);
    }

    /**
     * See {@link #twoSumExists(long[], long, boolean)}
     */
    public boolean twoSumExists(final int[] array, final int sum, final boolean distinct) {
        return !(array.length == 0 || array.length == 1) && doTwoSumExists(array, sum, distinct);
    }

    protected abstract boolean doTwoSumExists(final int[] array, final int sum, final boolean distinct);

    protected abstract boolean doTwoSumExists(final long[] array, final long sum, final boolean distinct);
}
