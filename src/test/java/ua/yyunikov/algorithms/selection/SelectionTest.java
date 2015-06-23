package ua.yyunikov.algorithms.selection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.yyunikov.algorithms.AlgorithmTest;

import java.util.Arrays;

public class SelectionTest extends AlgorithmTest {

    private static final int[] UNSORTED_UNREPEATABLE_ARRAY = new int[]{5, 7, 1, 3, 9, 15, 4, 55, 12, 0};
    private static final int[] UNSORTED_REPEATABLE_ARRAY = new int[]{5, 7, 1, 3, 9, 15, 4, 3, 55, 12, 0, 1, 55};
    private static final int[] UNSORTED_RANDOM_HUNDRED_TEN_THOUSAND_ARRAY = generateRandomArray(TEN_THOUSAND);
    private static final int[] SORTED_RANDOM_TEN_THOUSAND_ARRAY = javaSort(UNSORTED_RANDOM_HUNDRED_TEN_THOUSAND_ARRAY);

    private int[] unrepeatableUnsortedArray;
    private int[] repeatableUnsortedArray;
    private int[] randomTenThousandUnsortedArray;

    @Before
    public void initArrays() {
        unrepeatableUnsortedArray = UNSORTED_UNREPEATABLE_ARRAY.clone();
        repeatableUnsortedArray = UNSORTED_REPEATABLE_ARRAY.clone();
        randomTenThousandUnsortedArray = UNSORTED_RANDOM_HUNDRED_TEN_THOUSAND_ARRAY.clone();
    }

    @Test
    public void testRandomizedSelection() {
        testSelection(new QuickSelect());
    }

    private void testSelection(final Selection selection) {
        runningTimeOf(selection.getClass().getSimpleName(), () -> {
            Assert.assertEquals(9, selection.select(unrepeatableUnsortedArray, 6));
            Assert.assertEquals(3, selection.select(repeatableUnsortedArray, 3));
            Assert.assertEquals(SORTED_RANDOM_TEN_THOUSAND_ARRAY[1000], selection.select(randomTenThousandUnsortedArray, 1000));
        });
    }

    private static int[] javaSort(final int[] array) {
        final int[] copy = array.clone();
        Arrays.sort(copy);
        return copy;
    }
}
