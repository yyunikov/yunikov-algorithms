package ua.yyunikov.algorithms.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SmallDataSortTest extends SortTest {

    private static final int[] UNSORTED_UNREPEATABLE_ARRAY = new int[]{5, 7, 1, 3, 9, 15, 4, 55, 12, 0};
    private static final int[] SORTED_UNREPEATABLE_ARRAY = new int[]{0, 1, 3, 4, 5, 7, 9, 12, 15, 55};

    private static final int[] UNSORTED_REPEATABLE_ARRAY = new int[]{5, 7, 1, 3, 9, 15, 4, 3, 55, 12, 0, 1, 55};
    private static final int[] SORTED_REPEATABLE_ARRAY = new int[]{0, 1, 1, 3, 3, 4, 5, 7, 9, 12, 15, 55, 55};

    private static final int[] UNSORTED_RANDOM_HUNDRED_TEN_THOUSAND_ARRAY = generateRandomArray(TEN_THOUSAND);
    private static final int[] SORTED_RANDOM_TEN_THOUSAND_ARRAY = javaSort(UNSORTED_RANDOM_HUNDRED_TEN_THOUSAND_ARRAY);

    private int[] unrepeatableUnsortedArray;
    private int[] repeatableUnsortedArray;
    private int[] repeatableSortedArray;
    private int[] randomTenThousandUnsortedArray;
    private int[] randomTenThousandSortedArray;

    @Before
    public void initArrays() {
        unrepeatableUnsortedArray = UNSORTED_UNREPEATABLE_ARRAY.clone();
        repeatableUnsortedArray = UNSORTED_REPEATABLE_ARRAY.clone();
        repeatableSortedArray = SORTED_REPEATABLE_ARRAY.clone();
        randomTenThousandUnsortedArray = UNSORTED_RANDOM_HUNDRED_TEN_THOUSAND_ARRAY.clone();
        randomTenThousandSortedArray = SORTED_RANDOM_TEN_THOUSAND_ARRAY.clone();
    }

    @Test
    public void testJavaSort() {
        runningTimeOf("Java Arrays.sort()", () -> {
            Arrays.sort(unrepeatableUnsortedArray);
            Arrays.sort(repeatableUnsortedArray);
            Arrays.sort(repeatableSortedArray);
            Arrays.sort(randomTenThousandUnsortedArray);
            Arrays.sort(randomTenThousandSortedArray);
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

    @Test
    public void testInsertionSort() {
        testSort(new InsertionSort());
    }

    @Test
    public void testSelectionSort() {
        testSort(new SelectionSort());
    }

    @Test
    public void testBubbleSort() {
        testSort(new BubbleSort());
    }

    @Override
    protected void testSort(final Sort sort) {
        runningTimeOf(sort.getClass().getSimpleName(), () -> {
            sort.sort(unrepeatableUnsortedArray);
            sort.sort(repeatableUnsortedArray);
            sort.sort(repeatableSortedArray);
            sort.sort(randomTenThousandUnsortedArray);
            sort.sort(randomTenThousandSortedArray);
        }).asserting(this::assertSort);
    }

    private void assertSort() {
        Assert.assertArrayEquals(SORTED_UNREPEATABLE_ARRAY, unrepeatableUnsortedArray);
        Assert.assertArrayEquals(SORTED_REPEATABLE_ARRAY, repeatableUnsortedArray);
        Assert.assertArrayEquals(SORTED_REPEATABLE_ARRAY, repeatableSortedArray);
        Assert.assertArrayEquals(SORTED_RANDOM_TEN_THOUSAND_ARRAY, randomTenThousandUnsortedArray);
        Assert.assertArrayEquals(SORTED_RANDOM_TEN_THOUSAND_ARRAY, randomTenThousandSortedArray);
    }
}