package ua.yyunikov.algorithms.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class SortTest {

    private static final int MILLION = 1000000;

    private static final int[] UNSORTED_UNREPEATABLE_ARRAY = new int[]{5, 7, 1, 3, 9, 15, 4, 55, 12, 0};
    private static final int[] SORTED_UNREPEATABLE_ARRAY = new int[]{0, 1, 3, 4, 5, 7, 9, 12, 15, 55};

    private static final int[] UNSORTED_REPEATABLE_ARRAY = new int[]{5, 7, 1, 3, 9, 15, 4, 3, 55, 12, 0, 1, 55};
    private static final int[] SORTED_REPEATABLE_ARRAY = new int[]{0, 1, 1, 3, 3, 4, 5, 7, 9, 12, 15, 55, 55};

    private static final int[] UNSORTED_RANDOM_BIG_ARRAY = generateRandomArray(MILLION);
    private static final int[] SORTED_RANDOM_BIG_ARRAY = javaSort(UNSORTED_RANDOM_BIG_ARRAY);

    private int[] unrepeatableTestArray;
    private int[] repeatableTestArray;
    private int[] randomBigTestArray;

    @Before
    public void initArrays() {
        unrepeatableTestArray = UNSORTED_UNREPEATABLE_ARRAY.clone();
        repeatableTestArray = UNSORTED_REPEATABLE_ARRAY.clone();
        randomBigTestArray = UNSORTED_RANDOM_BIG_ARRAY.clone();
    }

    @Test
    public void testJavaSort() {
        Arrays.sort(unrepeatableTestArray);
        Assert.assertArrayEquals(unrepeatableTestArray, SORTED_UNREPEATABLE_ARRAY);
        Arrays.sort(repeatableTestArray);
        Assert.assertArrayEquals(repeatableTestArray, SORTED_REPEATABLE_ARRAY);
        Arrays.sort(randomBigTestArray);
        Assert.assertArrayEquals(randomBigTestArray, SORTED_RANDOM_BIG_ARRAY);
    }

    @Test
    public void testMergeSort() {
        testSort(new MergeSort());
    }

    @Test
    public void testSlowInsertionSort() {
        testSlowSort(new InsertionSort());
    }

    @Test
    public void testSlowSelectionSort() {
        testSlowSort(new SelectionSort());
    }

    @Test
    public void testSlowBubbleSort() {
        testSlowSort(new BubbleSort());
    }

    private void testSlowSort(final Sort sort) {
        Assert.assertArrayEquals(sort.sort(unrepeatableTestArray), SORTED_UNREPEATABLE_ARRAY);
        Assert.assertArrayEquals(sort.sort(repeatableTestArray), SORTED_REPEATABLE_ARRAY);
    }

    private void testSort(final Sort sort) {
        Assert.assertArrayEquals(sort.sort(unrepeatableTestArray), SORTED_UNREPEATABLE_ARRAY);
        Assert.assertArrayEquals(sort.sort(repeatableTestArray), SORTED_REPEATABLE_ARRAY);
        Assert.assertArrayEquals(sort.sort(randomBigTestArray), SORTED_RANDOM_BIG_ARRAY);
    }

    private static int[] generateRandomArray(final int size) {
        final int[] bigArray = new int[size];
        final Random random = new Random();

        for(int i = 0; i < size; i++) {
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