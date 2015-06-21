package ua.yyunikov.algorithms.sort;

import org.junit.BeforeClass;
import ua.yyunikov.algorithms.AlgorithmAssert;
import ua.yyunikov.algorithms.AlgorithmTest;

import java.util.Arrays;
import java.util.Random;

public abstract class SortTest {

    @BeforeClass
    public static void warmUp() throws InterruptedException {
        // warming up for 2 seconds to make running time more precise
        Thread.sleep(2000);
    }

    protected abstract void testSort(final Sort sort);

    protected static int[] generateRandomArray(final int size) {
        final int[] bigArray = new int[size];
        final Random random = new Random();

        for(int i = 0; i < size; i++) {
            bigArray[i] = random.nextInt();
        }

        return bigArray;
    }

    protected static int[] javaSort(final int[] array) {
        final int[] copy = array.clone();
        Arrays.sort(copy);
        return copy;
    }

    protected SortTest testRunningTime(final String algorithmName, final AlgorithmTest assertSort) {
        final long startTime = System.currentTimeMillis();

        assertSort.testAlgorithm();

        final long endTime = System.currentTimeMillis();
        System.out.println(algorithmName + " running time: " + (endTime - startTime) / 1000.0);

        return this;
    }

    protected void asserting(final AlgorithmAssert algorithmAssert) {
        algorithmAssert.assertAlgorithm();
    }
}
