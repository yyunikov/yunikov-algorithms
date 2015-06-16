package ua.yyunikov.algorithms.inversions;

import org.junit.Assert;
import org.junit.Test;

public class InversionsCountTest {

    private static final int[] UNSORTED_SMALL_UNREPEATABLE_ARRAY = new int[]{1, 3, 5, 2, 4, 6};
    private static final int[] UNSORTED_SMALL_UNREPEATABLE_ARRAY_2 = new int[]{2, 4, 1, 3, 5};
    private static final int[] UNSORTED_SMALL_UNREPEATABLE_ARRAY_3 = new int[]{4, 1, 5, 2, 6, 3};
    private static final int[] UNSORTED_SMALL_UNREPEATABLE_ARRAY_4 = new int[]{1, 20, 6, 4, 5};
    private static final int[] UNSORTED_SMALL_UNREPEATABLE_ARRAY_5 = new int[]{6, 5, 4, 3, 2, 1};

    @Test
    public void testBruteForceCount() {
        testInversionsCount(new BruteForceInversionsCount());
    }

    @Test
    public void testDivideConquerCount() {
        testInversionsCount(new MergeInversionsCount());
    }

    private void testInversionsCount(final InversionsCount inversionsCount) {
        Assert.assertEquals(3, inversionsCount.count(UNSORTED_SMALL_UNREPEATABLE_ARRAY));
        Assert.assertEquals(3, inversionsCount.count(UNSORTED_SMALL_UNREPEATABLE_ARRAY_2));
        Assert.assertEquals(6, inversionsCount.count(UNSORTED_SMALL_UNREPEATABLE_ARRAY_3));
        Assert.assertEquals(5, inversionsCount.count(UNSORTED_SMALL_UNREPEATABLE_ARRAY_4));
        Assert.assertEquals(15, inversionsCount.count(UNSORTED_SMALL_UNREPEATABLE_ARRAY_5));
    }
}
