package com.yunikov.algorithms.median;

import com.yunikov.algorithms.AlgorithmTest;
import org.junit.Assert;
import org.junit.Test;
import com.yunikov.algorithms.util.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MedianMaintenanceTest extends AlgorithmTest {

    private static final List<Integer> TEST_LIST = new ArrayList<>(Arrays.asList(2, 4, 5, -11, 5, 0, 4, 1, -4, 1, 5, 8));
    private static final List<Integer> RESULT_LIST = new ArrayList<>(Arrays.asList(2, 2, 4, 2, 4, 2, 4, 2, 2, 1, 2, 2));

    @Test
    public void testHeapMedianMaintenance() {
        testMedianMaintenance("Heap median maintenance", new HeapMedianMaintenance());
    }

    private void testMedianMaintenance(final String algorithmName, final MedianMaintenance medianMaintenance) {
        runningTimeOf(algorithmName, () -> {
            // test 1
            final List<Integer> resultList = medianMaintenance.findOneByOne(TEST_LIST);
            Assert.assertArrayEquals(RESULT_LIST.toArray(), resultList.toArray());

            // test 2
            try {
                final int[] array = FileUtils.toIntArray("src/test/java/ua/yyunikov/algorithms/median/Median.txt");
                final int sum = medianMaintenance
                        .findOneByOne(
                                Arrays
                                        .stream(array)
                                        .boxed()
                                        .collect(Collectors.toList())
                        )
                        .stream()
                        .mapToInt(value -> value)
                        .sum();

                Assert.assertEquals(1213, sum % 10000);
            } catch (IOException e) {
                System.err.println("Unexpected error: " + e);
            }
        });
    }
}
