package ua.yyunikov.algorithms.inversions;

import org.junit.Assert;
import org.junit.Test;

public class InversionsCountTest {

    private static final int[] UNSORTED_SMALL_UNREPEATABLE_ARRAY = new int[]{1, 3, 5, 2, 4, 6};

    @Test
    public void testBruteForceCount() {
        testInversionsCount(new BruteForceInversionsCount());
    }

    @Test
    public void testDivideConquerCount() {
        testInversionsCount(new DivideConquerInversionsCount());
    }

    private void testInversionsCount(final InversionsCount inversionsCount) {
        Assert.assertEquals(3, inversionsCount.count(UNSORTED_SMALL_UNREPEATABLE_ARRAY));
    }
}
