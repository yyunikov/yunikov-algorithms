package ua.yyunikov.algorithms.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class BigDataSortTest extends SortTest {

    private static final int[] UNSORTED_RANDOM_BIG_NUMBERS_ARRAY = generateRandomArray(MILLION);
    private static final int[] SORTED_RANDOM_BIG_NUMBERS_ARRAY = javaSort(UNSORTED_RANDOM_BIG_NUMBERS_ARRAY);

    private int[] randomBigUnsortedArray;
    private int[] randomBigSortedArray;

    @Before
    public void initArrays() {
        randomBigUnsortedArray = UNSORTED_RANDOM_BIG_NUMBERS_ARRAY.clone();
        randomBigSortedArray = SORTED_RANDOM_BIG_NUMBERS_ARRAY.clone();
    }

    @Test
    public void testJavaSort() {
        testRunningTime("Java Arrays.sort()", () -> {
            Arrays.sort(randomBigUnsortedArray);
            Arrays.sort(randomBigSortedArray);
        }).asserting(this::assertSort);
    }

    @Test
    public void testQuickSort() {
        testSort(new QuickSort());
    }

    @Test
    public void testMergeSort() {
        testSort(new MergeSort());
    }

    @Override
    protected void testSort(final Sort sort) {
        testRunningTime(sort.getClass().getSimpleName(), () -> {
            sort.sort(randomBigUnsortedArray);
            sort.sort(randomBigSortedArray);
        }).asserting(this::assertSort);
    }

    private void assertSort() {
        Assert.assertArrayEquals(SORTED_RANDOM_BIG_NUMBERS_ARRAY, randomBigUnsortedArray);
        Assert.assertArrayEquals(SORTED_RANDOM_BIG_NUMBERS_ARRAY, randomBigSortedArray);
    }
}