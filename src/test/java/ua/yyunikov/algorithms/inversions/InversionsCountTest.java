package ua.yyunikov.algorithms.inversions;

import org.junit.Assert;
import org.junit.Test;
import ua.yyunikov.algorithms.AlgorithmTest;

public class InversionsCountTest extends AlgorithmTest {

    private static final int[] UNSORTED_SMALL_UNREPEATABLE_ARRAY = new int[]{1, 3, 5, 2, 4, 6};
    private static final int[] UNSORTED_SMALL_UNREPEATABLE_ARRAY_2 = new int[]{2, 4, 1, 3, 5};
    private static final int[] UNSORTED_SMALL_UNREPEATABLE_ARRAY_3 = new int[]{4, 1, 5, 2, 6, 3};
    private static final int[] UNSORTED_SMALL_UNREPEATABLE_ARRAY_4 = new int[]{1, 20, 6, 4, 5};
    private static final int[] UNSORTED_SMALL_UNREPEATABLE_ARRAY_5 = new int[]{6, 5, 4, 3, 2, 1};
    private static final int[] UNSORTED_RANDOM_HUNDRED_TEN_THOUSAND_ARRAY = generateRandomArray(TEN_THOUSAND);

    @Test
    public void testBruteForceCount() {
        testInversionsCount(new BruteForceInversionsCount());
    }

    @Test
    public void testMergeSortCount() {
        testInversionsCount(new MergeSortInversionsCount());
    }

    private void testInversionsCount(final InversionsCount inversionsCount) {
        runningTimeOf(inversionsCount.getClass().getSimpleName(), () -> {
            Assert.assertEquals(3, inversionsCount.count(UNSORTED_SMALL_UNREPEATABLE_ARRAY));
            Assert.assertEquals(3, inversionsCount.count(UNSORTED_SMALL_UNREPEATABLE_ARRAY_2));
            Assert.assertEquals(6, inversionsCount.count(UNSORTED_SMALL_UNREPEATABLE_ARRAY_3));
            Assert.assertEquals(5, inversionsCount.count(UNSORTED_SMALL_UNREPEATABLE_ARRAY_4));
            Assert.assertEquals(15, inversionsCount.count(UNSORTED_SMALL_UNREPEATABLE_ARRAY_5));

            inversionsCount.count(UNSORTED_RANDOM_HUNDRED_TEN_THOUSAND_ARRAY);
        });
    }
}
