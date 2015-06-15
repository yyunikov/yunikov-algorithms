package ua.yyunikov.algorithms.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class SortTest {

    private static final int[] UNSORTED_UNREPEATABLE_ARRAY = new int[]{5, 7, 1, 3, 9, 15, 4, 55, 12, 0};
    private static final int[] SORTED_UNREPEATABLE_ARRAY = new int[]{0, 1, 3, 4, 5, 7, 9, 12, 15, 55};

    private static final int[] UNSORTED_REPEATABLE_ARRAY = new int[]{5, 7, 1, 3, 9, 15, 4, 3, 55, 12, 0, 1, 55};
    private static final int[] SORTED_REPEATABLE_ARRAY = new int[]{0, 1, 1, 3, 3, 4, 5, 7, 9, 12, 15, 55, 55};

    private static final int[] UNSORTED_RANDOM_BIG_ARRAY = generateRandomBigArray();
    private static final int[] SORTED_RANDOM_BIG_ARRAY = javaSort(UNSORTED_RANDOM_BIG_ARRAY);

    @Test
    public void testMergeSort() {
        testSort(new MergeSort());
    }

    @Test
    public void testInsertionSort() {
        testSort(new InsertionSort());
    }

    @Test
    public void testSelectionSort() {
        testSort(new SelectionSort());
    }

    // TODO add performance test

    private void testSort(final Sort sort) {
        Assert.assertArrayEquals(sort.sort(UNSORTED_UNREPEATABLE_ARRAY), SORTED_UNREPEATABLE_ARRAY);
        Assert.assertArrayEquals(sort.sort(UNSORTED_REPEATABLE_ARRAY), SORTED_REPEATABLE_ARRAY);
        Assert.assertArrayEquals(sort.sort(UNSORTED_RANDOM_BIG_ARRAY), SORTED_RANDOM_BIG_ARRAY);
    }

    private static int[] generateRandomBigArray() {
        final int hunredThousand = 100000;

        final int[] bigArray = new int[hunredThousand];
        final Random random = new Random();

        for(int i = 0; i < hunredThousand; i++) {
            bigArray[i] = random.nextInt();
        }

        return bigArray;
    }

    private static int[] javaSort(final int[] array) {
        final int[] copy = array.clone();
        Arrays.sort(copy);
        return copy;
    }
}